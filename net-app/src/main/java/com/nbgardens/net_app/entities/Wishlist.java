package com.nbgardens.net_app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Wishlist")
public class Wishlist {
	
	@Id //ID is for PK
	@Column (name = "WishList_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Integer wishlistID;
	
	@Column (name = "Total_Price", length = 255)
	private String totalPrice;
	
	//Constructors
	public Wishlist(){}
	public void WishList(String totalPrice){
		this.totalPrice = totalPrice;

	}
	
	
	//GETTERS AND SETTERS
	public Integer getWishlistID() {
		return wishlistID;
	}
	public void setWishlistID(Integer wishlistID) {
		this.wishlistID = wishlistID;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
