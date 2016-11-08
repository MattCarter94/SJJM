package com.qac.nbgardens.entities;

import java.util.Currency;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "User")
public class Customer {
	
	private enum Permissions{
		Customer, Admin, IMS
	};
	
	@Id //PK
	@Column (name = "User_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer userID;
	
	@Id //PK / Composite key
	@Column (name = "CardNo")  
	private CardDetails card;
	
	@OneToOne //FK.
	@JoinColumn(name="Wishlist_ID", nullable = false)
	@NotNull
	private WishlistProduct wishlistProduct;
	
	@Column (name = "First_Name", length = 255)
	private String firstName;
	
	@Column (name = "Surname", length = 255)
	private String surname;
	
	@Column (name = "Credit")
	private double credit;
	
	@Column (name = "Email", length = 255)
	private String email;
	
	@Column (name = "Phone_Number")
	private String phoneNumber;
	
	@Column (name = "Password", length = 255)
	private String password;
	
	@Column (name = "Address", length = 255)
	private Address address;
	
	//End of variables
	
	//Constructors
	public Customer() {};
	public Customer(CardDetails card, String firstName, String surname, String email, String phoneNo, String password, Address address) {
		this.card = card;


		this.firstName = firstName;
		this.surname = surname;
		this.email = email;
		this.phoneNumber = phoneNo;
		this.password = password;
		this.address = address;
		this.wishlistProduct = new WishlistProduct();
		this.credit = 10000;
	}
	
	
	//End constructors
	
	//GETTERS AND SETTERS
	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNo(String phoneNumber) {
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
	
	public WishlistProduct getWishlistProduct() {
		return wishlistProduct;
	}
	
	public void setWishlistProduct(WishlistProduct wishlist) {
		this.wishlistProduct = wishlist;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
