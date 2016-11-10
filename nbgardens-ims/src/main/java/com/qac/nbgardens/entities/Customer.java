package com.qac.nbgardens.entities;


import java.util.ArrayList;

import java.util.List;


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


	
	private List<WishlistProduct> customerWishlistProducts;
	private List<CustomerCard> customerCards;
	private List<CustomerAddress> customerAddresses;
	private List<CustomerOrder> customerOrders;
	
	//End of variables
	
	//Constructors
	public Customer(String customerEmail, String firstName, String surname,
			 String phoneNumber, String password) {
		this.customerEmail = customerEmail;
		this.firstName = firstName;
		this.surname = surname;
		this.credit = 10000;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.customerWishlistProducts = new ArrayList<WishlistProduct>();
		this.customerCards = new ArrayList<CustomerCard>();
		this.customerAddresses = new ArrayList<CustomerAddress>();
		this.customerOrders = new ArrayList<CustomerOrder>();
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

	public List<WishlistProduct> getCustomerWishlistProducts() {
		return customerWishlistProducts;
	}

	public void setCustomerWishlistProducts(List<WishlistProduct> customerWishlistProducts) {
		this.customerWishlistProducts = customerWishlistProducts;
	}
	
	public void addCustomerWishlistProduct(WishlistProduct w) {
		this.customerWishlistProducts.add(w);
	}

	public List<CustomerCard> getCustomerCards() {
		return customerCards;
	}

	public void setCustomerCards(List<CustomerCard> customerCards) {
		this.customerCards = customerCards;
	}
	
	public void addCustomerCard(CustomerCard c) {
		this.customerCards.add(c);
	}

	public List<CustomerAddress> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(List<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}
	
	public void addCustomerAddress(CustomerAddress c) {
		this.customerAddresses.add(c);
	}

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}
	
}
