package com.nbgardens.net_app;

import java.util.Currency;

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
	private Basket basketID;
	
	@OneToOne //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Product productID;
	
	@Column (name = "Quantity")
	@NotNull
	private Integer quantity;
	
	
	public BasketProduct(){};
	public BasketProduct(Basket basketID, Product productID, Integer quantity ){
		this.basketID = basketID;
		this.productID = productID;
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
		return basketID;
	}
	public void setBasketID(Basket basketID) {
		this.basketID = basketID;
	}
	public Product getProductID() {
		return productID;
	}
	public void setProductID(Product productID) {
		this.productID = productID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
