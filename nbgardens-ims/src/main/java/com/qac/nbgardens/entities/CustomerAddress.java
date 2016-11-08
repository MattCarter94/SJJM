package com.qac.nbgardens.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class CustomerAddress {
	
	
	@Id //ID is for PK
	@OneToMany //For FK.
	@Column (name = "Address_ID")  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@Id //ID is for PK
	@OneToMany //For FK.
	@JoinColumn (name = "Email")  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String email;


	private Address address;


	public CustomerAddress(Integer addressId, String email, Address address) {
		this.addressId = addressId;
		this.email = email;
		this.address = address;
	}


	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

}
