package com.qac.nbgardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Customer_Card")
public class CustomerCard {
	
	
	@Id //PK
	@OneToOne
	@Column (name = "Card_Number", length = 255)  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private CardDetails card;
	
	@Id //PK
	@OneToOne
	@Column (name = "Email", length = 255)  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Customer customer;
	

	
	public CustomerCard(){}
	public CustomerCard(Customer customer, CardDetails card) {
		this.customer = customer;
		this.card = card;
	}


	// GETTERS & SETTERS

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CardDetails getCard() {
		return card;
	}

	public void setCard(CardDetails card) {
		this.card = card;
	}

}
