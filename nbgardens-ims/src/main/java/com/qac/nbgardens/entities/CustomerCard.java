package com.qac.nbgardens.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerCard {
	
	
	@Id //PK
	@Column (name = "Card_No", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private CardDetails card_number;
	
	@Id //PK
	@Column (name = "Email", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String custEmail;

	
	// Constructors
	
	public CustomerCard() {};
	
	public CustomerCard(CardDetails card_number, String custEmail) {
	
		this.card_number = card_number;
		this.custEmail = custEmail;
	}
	
	
	// GETTERS & SETTERS
	public CardDetails getCard_number() {
		return card_number;
	}

	public void setCard_number(CardDetails card_number) {
		this.card_number = card_number;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	
	

}
