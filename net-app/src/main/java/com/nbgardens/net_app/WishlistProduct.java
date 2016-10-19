package com.nbgardens.net_app;

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
	@JoinColumn(name="WishList_ID", nullable = false)
	@NotNull
	private Wishlist wishListID;   
	
	
	@OneToOne //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Product productID;
	
	
	//GETTERS AND SETTERS
	public Integer getWpID() {
		return wpID;
	}
	public void setWpID(Integer wpID) {
		this.wpID = wpID;
	}
	public Wishlist getwishListID() {
		return wishListID;
	}
	public void setwishListID(Wishlist wishListID) {
		this.wishListID = wishListID;
	}
	public Product getProductID() {
		return productID;
	}
	public void setProductID(Product productID) {
		this.productID = productID;
	}
	
}
