package com.qac.nbgardens.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class CustomerCard {
	
	
	@Id //PK
	@OneToOne
	@Column (name = "Card_No", length = 255)  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String cardNo;
	
	@Id //PK
	@OneToOne
	@Column (name = "Email", length = 255)  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String customerEmail;
	

	private CardDetails card;

	
	
	public CustomerCard(String cardNo, String customerEmail, CardDetails card) {
		this.cardNo = cardNo;
		this.customerEmail = customerEmail;
		this.card = card;
	}


	// GETTERS & SETTERS
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public CardDetails getCard() {
		return card;
	}

	public void setCard(CardDetails card) {
		this.card = card;
	}

}
