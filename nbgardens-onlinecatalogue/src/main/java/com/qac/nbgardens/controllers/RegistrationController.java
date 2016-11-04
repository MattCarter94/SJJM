package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.service.RegistrationService;
import com.qac.nbgardens.util.InitialData;

@RequestScoped
@Named("register")
public class RegistrationController implements Serializable {
	@Inject
	private RegistrationService registrationService;

	private Customer user;
	
	@Inject
	private InitialData initialData;
	
	private String error;
	private String firstName;
	private String surname;
	private String email;
	private String password;
	private String phoneNo;
	
	private String houseNo;
	private String street;
	private String town;
	private String county;
	private String postcode;
	
	private String cardName;
	private String cardNo;
	private String expiry;

	public String register(){
	
		if(email.equals("")) {
			error = "Please enter a valid email address";
			System.out.println("Email entered is: " + email);
			return "catalogue";
			
		}
		if(password.equals("")){
			error = "Please enter a valid password";
			System.out.println("Password entered is: " + password);
			return "catalogue";
		}
		
		Customer c = new Customer(new CardDetails(this.cardNo, this.expiry), this.firstName, this.surname, this.email, this.phoneNo, this.password, this.houseNo, this.street, this.town, this.county, this.postcode);
		initialData.addUser(c);
		//System.out.println("The last added user's first name is: " + initialData.returnLastUser());
		
		return "index";
	}
	
	
	//Getters and setters
	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	
	
}
