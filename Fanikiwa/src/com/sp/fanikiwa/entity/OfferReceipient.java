package com.sp.fanikiwa.entity;

 
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class OfferReceipient {

	@Id
	Long offerReceipientId;

 
	private String idType;

 
	private String mailingGroup;

 
	private String memberEmail;

 
	private Long memberId;

 
	private String memberTelno;
 
	private int offerId;

	public OfferReceipient() {
	}

	public Long getOfferReceipientId() {
		return this.offerReceipientId;
	}

	public void setOfferReceipientId(Long offerReceipientId) {
		this.offerReceipientId = offerReceipientId;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getMailingGroup() {
		return this.mailingGroup;
	}

	public void setMailingGroup(String mailingGroup) {
		this.mailingGroup = mailingGroup;
	}

	public String getMemberEmail() {
		return this.memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getMemberTelno() {
		return this.memberTelno;
	}

	public void setMemberTelno(String memberTelno) {
		this.memberTelno = memberTelno;
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

}