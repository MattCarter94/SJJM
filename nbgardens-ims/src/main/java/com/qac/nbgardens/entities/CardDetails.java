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
	private String cardNumber;
	
	@OneToMany //For FK.
	@JoinColumn(name="Address_ID", nullable = false)
	@NotNull
	private Integer addressId;
	
	@Column (name = "Name_On_Card", length = 255)
	private String nameOnCard;
	
	@Column (name = "Card_Expiry", length = 255)
	private Date cardExpiry;

	
	private Address address;
	
	// Constructors
	public CardDetails(){};
	
	


	public CardDetails(String cardNumber, Integer addressId, String nameOnCard, Date cardExpiry, Address address) {
		this.cardNumber = cardNumber;
		this.addressId = addressId;
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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
