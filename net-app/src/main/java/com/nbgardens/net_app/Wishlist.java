package com.nbgardens.net_app;

import java.util.List;

public class Wishlist {
	private Integer wishlistID;
	private Integer userID;
	private Integer productID;
	private List<WishlistProduct> wishlistProducts;
	
	
	
	//GETTERS AND SETTERS
	public Integer getWishlistID() {
		return wishlistID;
	}
	public void setWishlistID(Integer wishlistID) {
		this.wishlistID = wishlistID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public List<WishlistProduct> getWishlistProducts() {
		return wishlistProducts;
	}
	public void setWishlistProducts(List<WishlistProduct> wishlistProducts) {
		this.wishlistProducts = wishlistProducts;
	}
}
