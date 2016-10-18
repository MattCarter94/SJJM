package com.nbgardens.net_app;

import java.util.Date;


public class CardDetails {
	private Integer cardID;
	private Integer userID;
	private String cardNo;
	private Date cardExpiry;
	
	
	
	
	
	//GETTERS AND SETTERS
	public Integer getCardID() {
		return cardID;
	}
	public void setCardID(Integer cardID) {
		this.cardID = cardID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	
}
