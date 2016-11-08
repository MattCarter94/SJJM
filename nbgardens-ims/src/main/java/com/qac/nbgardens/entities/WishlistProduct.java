package com.qac.nbgardens.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class WishlistProduct {

	@Id //PK
	@OneToOne
	@Column (name = "Email", length = 255)  
	private String email;
	
	@Id //PK
	@OneToOne
	@Column (name = "Product", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	
	private Product product;

	
	//Constructor
	public WishlistProduct(String email, Integer productId, Product product) {
		super();
		this.email = email;
		this.productId = productId;
		this.product = product;
	}


	
	//GETTERS & SETTERS
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}

	
}
