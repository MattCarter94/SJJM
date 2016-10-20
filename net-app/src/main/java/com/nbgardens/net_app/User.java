package com.nbgardens.net_app;

import java.util.Currency;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "User")
public class User {
	
	private enum Permissions{
		Customer, Admin, IMS
	};
	
	@Id //ID is for PK
	@Column (name = "User_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer userID;
	
	@Column (name = "First_Name", length = 255)
	private String firstName;
	
	@Column (name = "Surname", length = 255)
	private String surname;
	
	@Column (name = "Credit")
	private Currency credit;
	
	@Column (name = "Email", length = 255)
	private String email;
	
	@Column (name = "Phone_Number")
	private String phoneNumber;
	
	@Column (name = "Password", length = 255)
	private String password;
	
	@Column (name = "Permissions")
	private Permissions permissions;
	
	@Column (name = "Address_1", length = 255)
	private String address1;
	
	@Column (name = "Address_2", length = 255)
	private String address2;
	
	@Column (name = "Town", length = 255)
	private String town;
	
	@Column (name = "County", length = 255)
	private String county;
	
	@Column (name = "Postcode", length = 255)
	private String postcode;
	
	//End of variables
	
	//Constructors
	public User() {};
	public User(String name, String surname, String email, String phoneNo, String password, Integer permissions, String add1, String add2, String town, String county, String postcode) {
		this.firstName = name;
		this.surname = surname;
		this.credit = Currency.getInstance(Locale.UK);
		
		this.phoneNumber = phoneNo;
		this.password = password;
		//TODO FIX THIS: this.permissions = permissions;
		this.address1 = add1;
		this.address2 = add2;
		this.town = town;
		this.county = county;
		this.postcode = postcode;

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
	public Currency getCredit() {
		return credit;
	}
	public void setCredit(Currency credit) {
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
	public Permissions getPermissions() {
		return permissions;
	}
	public void setPermissions(Permissions permissions) {
		this.permissions = permissions;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
