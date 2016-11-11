package com.qac.nbgardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Address")
public class Address {

	@Id //ID is for PK
	@Column (name = "Address_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
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

	
	// Constructors
	public Address() {}
	public Address(String address1, String address2, String town, String county, String postcode) {
		this.address1 = address1;
		this.address2 = address2;
		this.town = town;
		this.county = county;
		this.postcode = postcode;
	}
	

	
	// GETTERS & SETTERS

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

	public Integer getAddressId() {
		return addressId;
	}

	
	
}
