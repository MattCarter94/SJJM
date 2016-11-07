package com.qac.nbgardens.entities;



import java.util.ArrayList;
import java.util.List;

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
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private List<Product> products;
	
	//Constructors
	public WishlistProduct(){
	
		this.products = new ArrayList<>();

	}
	
	
	
	//GETTERS AND SETTERS
	public Integer getWpID() {
		return wpID;
	}
	
	public void setWpID(Integer wpID) {
		this.wpID = wpID;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Product products) {
		this.products = new ArrayList<>();
	}
	
	public void addProduct(Product product){
		products.add(product);
	}
}
