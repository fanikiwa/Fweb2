package com.sp.fanikiwa.entity;

import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class OfferModel {

	@Id
	Long id;
 
	private Long memberId;
 
	private String description;
 
	private double amount;
 
	private int term;
 
	private double interest;
 
	private String publicOffer;
 
	private Date createdDate;
 
	private Date expiryDate;
 
	private String offerees;
 
	private String offerType;
 
	private byte partialPay;
 
	private String status;

	public OfferModel() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getInterest() {
		return this.interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getOfferees() {
		return this.offerees;
	}

	public void setOfferees(String offerees) {
		this.offerees = offerees;
	}

	public String getOfferType() {
		return this.offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public byte getPartialPay() {
		return this.partialPay;
	}

	public void setPartialPay(byte partialPay) {
		this.partialPay = partialPay;
	}

	public String getPublicOffer() {
		return this.publicOffer;
	}

	public void setPublicOffer(String publicOffer) {
		this.publicOffer = publicOffer;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTerm() {
		return this.term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

}