package com.qac.nbgardens.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Card_Details")
public class CardDetails {
	
	@Id //PK
	@Column (name = "Card_Number", length = 255)  
	private String cardNumber;
	
	@OneToMany //For FK.
	@JoinColumn(name="Address_ID", nullable = false)
	@NotNull
	private Address address;
	
	@Column (name = "Name_On_Card", length = 255)
	private String nameOnCard;
	
	@Column (name = "Card_Expiry", length = 255)
	private Date cardExpiry;

	
	
	// Constructors
	public CardDetails(){};
	public CardDetails(String cardNumber, String nameOnCard, Date cardExpiry, Address address) {
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.cardExpiry = cardExpiry;
		this.address = address;
	}




	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
