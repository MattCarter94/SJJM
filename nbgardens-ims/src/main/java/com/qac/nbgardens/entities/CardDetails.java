package com.qac.nbgardens.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class CardDetails {
	
	@Id //PK
	@Column (name = "Card_No", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String card_number;
	
	@OneToMany //For FK.
	@JoinColumn(name="CustomerCard", nullable = false)
	@NotNull
	private Address address;
	
	@Column (name = "First_Name", length = 255)
	private Date card_Expiry;

	
	// Constructors
	public CardDetails(){};
	
	public CardDetails(String card_number, Address address, Date card_Expiry) {
		this.card_number = card_number;
		this.address = address;
		this.card_Expiry = card_Expiry;
	}


	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getCard_Expiry() {
		return card_Expiry;
	}

	public void setCard_Expiry(Date card_Expiry) {
		this.card_Expiry = card_Expiry;
	}
	
	
}
