package com.sp.fanikiwa.business;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.ForbiddenException;
import com.google.api.server.spi.response.NotFoundException;
import com.sp.fanikiwa.Enums.OfferStatus;
import com.sp.fanikiwa.Enums.PostingCheckFlag;
import com.sp.fanikiwa.Enums.RepaymentInterval;
import com.sp.fanikiwa.api.AccountEndpoint;
import com.sp.fanikiwa.api.LoanEndpoint;
import com.sp.fanikiwa.api.MemberEndpoint;
import com.sp.fanikiwa.api.OfferEndpoint;
import com.sp.fanikiwa.api.STOEndpoint;
import com.sp.fanikiwa.business.financialtransactions.GenericTransaction;
import com.sp.fanikiwa.business.financialtransactions.NarrativeFormat;
import com.sp.fanikiwa.business.financialtransactions.TransactionFactory;
import com.sp.fanikiwa.business.financialtransactions.TransactionPost;
import com.sp.fanikiwa.entity.Account;
import com.sp.fanikiwa.entity.BatchSimulateStatus;
import com.sp.fanikiwa.entity.Loan;
import com.sp.fanikiwa.entity.Member;
import com.sp.fanikiwa.entity.Offer;
import com.sp.fanikiwa.entity.STO;
import com.sp.fanikiwa.entity.SimulatePostStatus;
import com.sp.fanikiwa.entity.Transaction;
import com.sp.fanikiwa.entity.TransactionType;
import com.sp.utils.Config;
import com.sp.utils.DateExtension;
import com.sp.utils.GLUtil;

public class AcceptOfferComponent {
	public AcceptOfferComponent() {

	}

	// / <summary>
	// / AcceptBorrowOffer business method.
	// / </summary>
	// / <param name="id">A id value.</param>
	// / <param name="account">A account value.</param>
	// / <param name="loan">A loan value.</param>
	// / <param name="aBorrowOffer">A offer value.</param>
	// /
	String userID = "SYS";
	String Authorizer = "Auth";

	public void AcceptBorrowOffer(Member lender, Offer aBorrowOffer)
			throws Exception {
		// /TODO realize accept offer usecase
		// /
		ValidateOffer(aBorrowOffer, lender);
		SetOfferStatus(aBorrowOffer, OfferStatus.Processing);

		// get the borrower from the offer
		MemberEndpoint mDAC = new MemberEndpoint();
		Member borrower = aBorrowOffer.getMember();
		if (borrower.getMemberId() == lender.getMemberId())
			throw new ForbiddenException("Cannot accept self offers");

		// Check ability to pay
		List<Transaction> txns = LoanTransactions(lender, borrower,
				aBorrowOffer);
		if (txns.size() < 4)
			throw new ForbiddenException("Loan Transactions not well formed");
		BatchSimulateStatus bss = TransactionPost.SimulatePost(txns,
				PostingCheckFlag.CheckLimitAndPassFlag);
		if (!bss.CanPost()) {
			String msg = "";
			for (SimulatePostStatus s : bss.SimulateStatus) {
				for (Exception e : s.Errors) {
					msg += e.getMessage() + "\n";
				}
			}
			throw new Exception("Simulation Error \n" + msg);
		}

		// create loan
		CreateLoan(borrower, lender, aBorrowOffer);
		SetOfferStatus(aBorrowOffer, OfferStatus.Closed);
	}

	// <summary>
	// AcceptLendOffer business method.
	// </summary>
	// <param name="loan">A loan value.</param>

	public void AcceptLendOffer(Member borrower, Offer aLendOffer)
			throws Exception {
		// /TODO realize accept offer usecase

		ValidateOffer(aLendOffer, borrower);
		SetOfferStatus(aLendOffer, OfferStatus.Processing);

		// get the lender from the offer
		MemberEndpoint mDAC = new MemberEndpoint();
		Member lender = aLendOffer.getMember(); // mDAC.getMemberByID(aLendOffer.getMemberId());
		if (borrower.getMemberId() == lender.getMemberId())
			throw new ForbiddenException("Cannot accept self offers");

		AccountEndpoint aep = new AccountEndpoint();
		Account lenderCurr = lender.getCurrentAccount();
		if (GLUtil.CheckLimit(lenderCurr, aLendOffer.getAmount())) {
			aep.UnBlockFunds(lenderCurr, aLendOffer.getAmount());
			CreateLoan(borrower, lender, aLendOffer);
		} else {
			throw new Exception("Insufficient Limit");
		}

		SetOfferStatus(aLendOffer, OfferStatus.Closed);
	}

	private void ValidateOffer(Offer offer, Member acceptee)
			throws ForbiddenException {

		if (offer.getStatus().equals("Processing")) {
			throw new NullPointerException(MessageFormat.format(
					"Offer [{0}] is already taken, Status is Processing. ",
					offer.getId()));
		}
		if (offer.getStatus().equals("Closed")) {
			throw new NullPointerException(MessageFormat.format(
					"Offer [{0}] is already taken,  Status is Closed. ",
					offer.getId()));
		}
		if (offer.getStatus().equals("Edit")) {
			throw new NullPointerException(MessageFormat.format(
					"Offer [{0}] is already taken,  Status is Edit. ",
					offer.getId()));
		}
		if (offer.getExpiryDate().after(new Date())) {
			throw new ForbiddenException(MessageFormat.format(
					"Offer [{0}] is expired. ", offer.getId()));
		}
		if (!offer.getPublicOffer() && !PrivateOfferred(offer, acceptee)) { // the
																			// offer
																			// is
																			// a
																			// private
																			// offer
																			// and
																			// you
																			// dont
																			// exist
																			// in
																			// th
																			// offerees
																			// list
			throw new ForbiddenException(MessageFormat.format(
					"Offer [{0}] is not offerred to you. ", offer.getId()));
		}
	}

	private boolean PrivateOfferred(Offer offer, Member member) {
		if (offer.getOfferees().contains(member.getEmail()))
			return true;
		if (offer.getOfferees().contains(member.getTelephone()))
			return true;
		return false;
	}

	private void CreateLoan(Member borrower, Member lender, Offer offer)
			throws NotFoundException, ConflictException {
		/*
		 * 1. The system blocks the �lend offer� so that other potential
		 * borrowers do not accept the offer 2. The system establishes the loan
		 * in the loan book 3. The system logs the loan repayment schedule in
		 * the diary 4. The systems creates electronic loan contract 5. The
		 * AccountingSystem posts the loan transaction with its attendant
		 * commission 6. The system closes the �lend offer� //these two are done
		 * by messaging component 7. The MessagingSystem sends the electronic
		 * loan contract 8. The MessagingSystem informs both the lender and
		 * borrower of the successful transaction
		 */

		// STEP 1 Establish Loan
		Loan loan = this.EstablishLoan(lender, borrower, offer);

		// STEP 2 Log Loan repayment scedhule
		LogLoanRepayment(lender, borrower, loan);

		// SETP 3 Post loan transation
		TransactionPost.Post(LoanTransactions(lender, borrower, offer));

	}

	// <summary>
	// AcceptPartialBorrowOffer business method.
	// </summary>
	// <param name="loan">A loan value.</param>
	// <param name="offer">A offer value.</param>
	public void AcceptPartialBorrowOffer(Member lender, Offer partialoffer)
			throws ForbiddenException, NotFoundException, ConflictException {
		// /TODO realize accept offer usecase

		// Get offer
		OfferEndpoint oep = new OfferEndpoint();
		Offer _offer = oep.getOfferByID(partialoffer.getId());
		// check that partial offer is less or equal to offer amount
		if (partialoffer.getAmount() > _offer.getAmount()) {
			throw new ForbiddenException(
					"Accepted Amount is greater than Offer Amount!");
		}

		// /
		// get the borrower from the offer
		Member borrower = partialoffer.getMember();

		CreateLoan(borrower, lender, partialoffer);

		// decrease offer amount. Use the OfferDAC
		_offer.setAmount(_offer.getAmount() - partialoffer.getAmount());

		// offer.Amount = offer.Amount - loan.Amount;
		if (_offer.getAmount() <= 0) {
			// Offer fully subscribed. Change the offer status to closed.
			SetOfferStatus(_offer, OfferStatus.Closed);
		} else {
			// unlock the offer. Change the offer status to Open.

		}

	}

	public void SetOfferStatus(Offer offer, OfferStatus status)
			throws NotFoundException {
		OfferEndpoint oep = new OfferEndpoint();
		offer.setStatus(status.toString());
		oep.updateOffer(offer);
	}

	public Loan EstablishLoan(Member lender, Member borrower, Offer offer)
			throws NotFoundException, ConflictException {
		LoanEndpoint loanepC = new LoanEndpoint();
		// create a new loan
		Loan loan = new Loan();

		// fill up loan details from offer details
		InterestComponent ic = new InterestComponent();
		double intr = ic.ComputeSimpleInterest(offer.getAmount(),
				offer.getTerm(), (double) offer.getInterest());
		loan.setTerm(offer.getTerm());
		loan.setAmount(offer.getAmount() + intr);
		loan.setInterest(offer.getInterest());
		loan.setMaturityDate(offer.getExpiryDate());
		loan.setCreatedDate(new Date());
		loan.setMemberId(borrower.getMemberId());
		loan.setOfferId(offer.getId());
		loan.setPartialPay(offer.getPartialPay());
		// loan.AccruedInterest = //compute accrued interest

		// Now create the loan in the loan book
		return loanepC.insertLoan(loan);
	}

	public void LogLoanRepayment(Member lender, Member borrower, Loan loan)
			throws NotFoundException, ConflictException {
		/*
		 * We create 2 STOs STO 1 - for Repoaying Dr Borrower.CurrentID with
		 * PayAmount Cr Investor.CurrentAcc with PayAmount
		 */

		STO lr = new STO();

		// fill up the repayment schedule

		lr.setInterval(RepaymentInterval.M.toString()); // Create enum called
														// RapaymentInterval
		lr.setNoOfPayments(loan.getTerm()); // no of payments is loan terms
		lr.setCreateDate(new Date());
		lr.setStartDate(new Date()); // when does repayment start);
		lr.setNextPayDate(DateExtension.addMonths(lr.getStartDate(), 1)); // next
																			// repayment
																			// starts
																			// a
																			// month
																			// from
																			// today
		lr.setEndDate(DateExtension.addMonths(lr.getStartDate(),
				lr.getNoOfPayments())); // when does repayment end? Repayment
										// ends start date plus no of payments
										// months
		lr.setDrAccount(borrower.getCurrentAccount().getAccountID()); // during
																		// loan
																		// repayment
																		// debit
																		// borrower
		lr.setCrAccount(lender.getCurrentAccount().getAccountID()); // during
																	// loan
																	// repayment
																	// credit
																	// lender
		lr.setCommissionAccount(Config.GetLong("COMMISSIONACCOUNT"));
		lr.setDrTxnType(Config.GetLong("LOANDRAWTRANSACTIONTYPE"));
		lr.setCrTxnType(Config.GetLong("LOANDRAWTRANSACTIONTYPE"));
		lr.setAmountPaid(0);
		lr.setPayAmount((loan.getAmount() / loan.getTerm()));
		lr.setTotalToPay(loan.getAmount());
		lr.setFeesFlag(Config.GetInt("LOANREPAYMENTFEESFLAG"));
		lr.setChargeWho((short) Config.GetInt("CHARGEWHOFLAG"));
		lr.setLimitFlag(0);
		lr.setPartialPay(loan.getPartialPay());

		STOEndpoint stPost = new STOEndpoint();
		stPost.insertSTO(lr);
	}

	public List<Transaction> LoanTransactions(Member lender, Member borrower,
			Offer offer) {
		// Use this for all general ledger methods that does not post

		// create all transactions
		List<Transaction> txns = new ArrayList<Transaction>();
		InterestComponent ic = new InterestComponent();
		double interest = ic.ComputeSimpleInterest(offer.getAmount(),
				offer.getTerm(), (double) offer.getInterest());

		// establish loan with attendant commission
		TransactionType tt = Config
				.GetTransactionType("ESTABLISHLOANTRANSACTIONTYPE");
		if (tt == null)
			throw new NullPointerException("Transaction type cannot be null");

		// the loan transaction also unblocks blocked funds
		GenericTransaction ltxn = new GenericTransaction(tt, "LES", new Date(),
				borrower.getLoanAccount(), lender.getInvestmentAccount(),
				offer.getAmount() + interest, false, "Y", Authorizer, userID,
				offer.getId().toString());
		txns.addAll(ltxn.GetTransactionsIncludingCommission(
				new NarrativeFormat(tt), new NarrativeFormat(tt)));

		// Disburse Amount
		TransactionType Distt = Config
				.GetTransactionType("DISBURSELOANTRANSACTIONTYPE");
		GenericTransaction Distxn = new GenericTransaction(Distt, "DIS",
				new Date(), lender.getCurrentAccount(),
				borrower.getCurrentAccount(), offer.getAmount(), false, "Y",
				Authorizer, userID, offer.getId().toString());

		txns.addAll(Distxn.GetTransactionsIncludingCommission(
				new NarrativeFormat(Distt), new NarrativeFormat(Distt)));
		return txns;
	}

}
