package com.qac.nbgardens.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Wishlist_Product")
public class WishlistProduct {

	@Id //PK
	@OneToOne
	@Column (name = "Customer_Email", length = 255)  
	private Customer customer;
	
	@Id //PK
	@OneToOne
	@Column (name = "Product_Product_ID", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Product product;

	
	//Constructor
	public WishlistProduct(){}
	public WishlistProduct(Customer customer, Integer productId, Product product) {
		this.customer = customer;
		this.product = product;
	}


	
	//GETTERS & SETTERS
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	
}
