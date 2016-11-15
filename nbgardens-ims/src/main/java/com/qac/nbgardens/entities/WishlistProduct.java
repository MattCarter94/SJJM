package com.qac.nbgardens.entities;

import java.util.ArrayList;
import java.util.List;

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
@Table (name = "Wishlist_Product")
public class WishlistProduct {

	@Id //ID is for PK
	@Column (name = "WishList_Product_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Integer wpID;
	
	@OneToOne //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private List<Product> products;
	
	
	
	//Constructor
	public WishlistProduct(){
		this.products = new ArrayList<>();
	}


	//GETTERS & SETTERS

	public Integer getWpID() {
		return wpID;
	}

	public void setWpID(Integer wpID) {
		this.wpID = wpID;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
		
}
