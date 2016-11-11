package com.qac.nbgardens.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Customer_Address")
public class CustomerAddress {
	
	
	@Id //ID is for PK
	@OneToOne //For FK.
	@JoinColumn (name = "Address_ID")  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Address address;

	@Id //ID is for PK
	@OneToOne //For FK.
	@JoinColumn (name = "Email")  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Customer customer;




	public CustomerAddress(){}
	public CustomerAddress(Customer customer, Address address) {
		this.address = address;
		this.customer = customer;
	}



	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

}
