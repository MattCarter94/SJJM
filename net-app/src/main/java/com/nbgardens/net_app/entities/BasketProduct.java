package com.nbgardens.net_app.entities;


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
@Table (name = "Basket_Product")
public class BasketProduct {
	
	@Id //ID is for PK
	@Column (name = "Basket_Product_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer bpID;
	
	@OneToOne //For FK.
	@JoinColumn(name="Basket_ID", nullable = false)
	@NotNull
	private Basket basket;
	
	@OneToOne //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Product product;
	
	@Column (name = "Quantity")
	@NotNull
	private Integer quantity;
	
	
	public BasketProduct(){};
	public BasketProduct(Basket basketID, Product productID, Integer quantity ){
		this.basket = basketID;
		this.product = productID;
		this.quantity = quantity;
	}
	
	
	
	
	//GETTERS AND SETTERS
	public Integer getBpID() {
		return bpID;
	}
	public void setBpID(Integer bpID) {
		this.bpID = bpID;
	}
	public Basket getBasketID() {
		return basket;
	}
	public void setBasketID(Basket basketID) {
		this.basket = basketID;
	}
	public Product getProductID() {
		return product;
	}
	public void setProductID(Product productID) {
		this.product = productID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
