package com.qac.nbgardens.entities;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries ({
	@NamedQuery (
		name = "findCustomerByEmail",
		query = "SELECT * FROM  Customers where c.email = :custEmail"
	)
})

@Entity
@Table (name = "Customers")
public class Customer {
	
	
	@Id //PK
	@Column (name = "Email", length = 255, unique = true)  
	//@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String customerEmail;
	
	@Column (name = "First_Name", length = 255)
	private String firstName;
	
	@Column (name = "Surname", length = 255)
	private String surname;
	
	@Column (name = "Credit")
	private double credit;
	
	@Column (name = "Phone_Number")
	private String phoneNumber;
	
	@Column (name = "Password", length = 255)
	private String password;

	@Column (name = "Card")  
	private CardDetails card;
	
	@Column (name = "Address")
	private Address address;
	
	@Column (name = "Wishlist")
	private WishlistProduct wishlistProduct;
	
	//End of variables
	
	
	
	//Constructors
	public Customer(String customerEmail, String firstName, String surname,
			 String phoneNumber, String password, Address address) {
		this.customerEmail = customerEmail;
		this.firstName = firstName;
		this.surname = surname;
		this.credit = 10000;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.wishlistProduct = new WishlistProduct();
		this.card = new CardDetails();
		this.address = address;
	}
	
	

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CardDetails getCard() {
		return card;
	}

	public void setCard(CardDetails card) {
		this.card = card;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public WishlistProduct getWishlistProduct() {
		return wishlistProduct;
	}

	public void setWishlistProduct(WishlistProduct wishlistProduct) {
		this.wishlistProduct = wishlistProduct;
	}
	
}
