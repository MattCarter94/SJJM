package com.qac.nbgardens.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "Author.findEmployeeByName",  
	        query = "from Employee e where e.name = :name"  
	        )  
	    }  
	)  


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
	private Wishlist wishList;   
	
	
	@OneToOne //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Product product;
	
	//Constructors
	public WishlistProduct(){}
	public WishlistProduct(Wishlist WishListID, Product ProductID ){
	
		this.wishList = WishListID;
		this.product = ProductID;

	}
	
	
	
	//GETTERS AND SETTERS
	public Integer getWpID() {
		return wpID;
	}
	public void setWpID(Integer wpID) {
		this.wpID = wpID;
	}
	public Wishlist getwishListID() {
		return wishList;
	}
	public void setwishListID(Wishlist wishListID) {
		this.wishList = wishListID;
	}
	public Product getProductID() {
		return product;
	}
	public void setProductID(Product productID) {
		this.product = productID;
	}
	
}
