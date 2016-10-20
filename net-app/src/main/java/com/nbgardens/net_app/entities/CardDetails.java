package com.nbgardens.net_app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Card_Details")
public class CardDetails {
	
	@Id //ID is for PK
	@Column (name = "CardNo") 
	@NotNull
	private String cardNo;
	
	@Column (name = "Card_Expiry")
	@NotNull
	private String cardExpiry;
	
	
	//Constructor
	public CardDetails(){};
	public CardDetails(String cardNo, String cardExpiry){
		this.cardNo = cardNo;
		this.cardExpiry = cardExpiry;
	};
	
	
	
	//GETTERS AND SETTERS
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	
}
