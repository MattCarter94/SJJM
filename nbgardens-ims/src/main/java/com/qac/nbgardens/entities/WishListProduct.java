package com.qac.nbgardens.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WishListProduct {

	@Id //PK
	@Column (name = "WishList_Class", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer wishList_Class;
	
	@Id //PK
	@Column (name = "Product", length = 255)  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Product product;

	//Constructor
	public WishListProduct(Integer wishList_Class, Product product_ID) {
		
		this.wishList_Class = wishList_Class;
		this.product = product_ID;
	}

	//GETTERS & SETTERS
	public Integer getWishList_Class() {
		return wishList_Class;
	}

	public void setWishList_Class(Integer wishList_Class) {
		this.wishList_Class = wishList_Class;
	}

	public Product getProduct_ID() {
		return product;
	}

	public void setProduct_ID(Product product_ID) {
		this.product = product_ID;
	}	
	
}
