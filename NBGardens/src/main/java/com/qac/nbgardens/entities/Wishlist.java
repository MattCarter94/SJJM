package com.qac.nbgardens.entities;

import java.math.BigDecimal;

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
	private BigDecimal totalPrice;
	
	//Constructors
	public Wishlist(){}
	public Wishlist(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	//GETTERS AND SETTERS
	public Integer getWishlistID() {
		return wishlistID;
	}
	public void setWishlistID(Integer wishlistID) {
		this.wishlistID = wishlistID;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
