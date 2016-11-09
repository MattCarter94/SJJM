package com.qac.nbgardens.entities;

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
	
	@Column (name= "Name_On_Card")
	@NotNull
	private String nameOnCard;
	
	@Column (name = "Card_Expiry")
	@NotNull
	private String cardExpiry;
	
	
	//Constructor
	public CardDetails(){};
	public CardDetails(String cardNo, String cardExpiry, String nameOnCard){
		this.cardNo = cardNo;
		this.cardExpiry = cardExpiry;
		this.nameOnCard = nameOnCard;
	};
	
	
	
	//GETTERS AND SETTERS
	
	public String getCardNo() {
		return cardNo;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
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
