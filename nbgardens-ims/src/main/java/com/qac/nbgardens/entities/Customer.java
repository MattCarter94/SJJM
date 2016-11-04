package com.qac.nbgardens.entities;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

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
@Table (name = "User")
public class Customer {
	
	private enum Permissions{
		Customer, Admin, IMS
	};
	
	@Id //PK
	@Column (name = "Email", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String custEmail;
	
	@OneToMany //For FK.
	@JoinColumn(name="CustomerCard", nullable = false)
	@NotNull
	private CustomerCard custCard;
	
	@OneToMany //For FK.
	@JoinColumn(name="WishList", nullable = false)
	@NotNull
	private WishListProduct custWishlist;
	
	@Column (name = "First_Name", length = 255)
	private String firstName;
	
	@Column (name = "Surname", length = 255)
	private String surname;
	
	@Column (name = "Credit")
	private Currency credit;
	
	@Column (name = "Phone_Number")
	private String phoneNumber;
	
	@Column (name = "Password", length = 255)
	private String password;
	
	@Column (name = "Permissions")
	private Permissions permissions;
	
	@Column (name = "CustomerOrders")
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	
	//End of variables
	
	//Constructors
	public Customer() {};
	
	public Customer(String email, CustomerCard customerCard, String name, String surname, String phoneNo, String password) {
		
		this.custEmail = email;
		this.custCard = customerCard;
		
		this.firstName = name;
		this.surname = surname;
		this.credit = Currency.getInstance(Locale.UK);
		this.phoneNumber = phoneNo;
		this.password = password;
	}
	
	
	//End constructors
//	public CustomerOrder addCustomerOrder(String Email,  BigDecimal Price  ){
//		return null;
//	}
	
	
	
	public void addCustomerOrder(CustomerOrder co) {	
		customerOrders.add(co);
	}
	

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	//GETTERS AND SETTERS
	public String getEmail() {
		return custEmail;
	}
	public void setEmail(String email) {
		this.custEmail = email;
	}
	
	
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public CustomerCard getCustCard_no() {
		return custCard;
	}
	public void setCustCard_no(CustomerCard custCard_no) {
		this.custCard = custCard_no;
	}
	public WishListProduct getCustWishlist() {
		return custWishlist;
	}
	public void setCustWishlist(WishListProduct custWishlist) {
		this.custWishlist = custWishlist;
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
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
