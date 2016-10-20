package com.nbgardens.net_app;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Wishlist")
public class Wishlist {
	
	@Id //ID is for PK
	@Column (name = "WishList_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)	
	private Integer wishlistID;
	
	
	@OneToOne //For FK.
	@JoinColumn(name="User_ID", nullable = false)
	@NotNull
	private User userID;
	
	
	@OneToMany //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private List<WishlistProduct> productID;
	
	//Constructors
	public Wishlist(){}
	public void WishList(User User_ID, List<WishlistProduct> Product_ID ){
	
		this.userID = User_ID;
		this.productID = Product_ID;

	}
	
	
	//GETTERS AND SETTERS
	public Integer getWishlistID() {
		return wishlistID;
	}
	public void setWishlistID(Integer wishlistID) {
		this.wishlistID = wishlistID;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	public List<WishlistProduct> getProductID() {
		return productID;
	}
	public void setProductID(List<WishlistProduct> productID) {
		this.productID = productID;
	}

}
