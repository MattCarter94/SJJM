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
@Table (name = "Basket_Product")
public class BasketProduct {
	
	@Id //ID is for PK
	@Column (name = "Basket_Product_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer bpID;
	
	@OneToZeroToMany //For FK.
	@JoinColumn(name="Basket_ID", nullable = false)
	@NotNull
	private Integer basketID;
	
	@ZeroToManyToZeroToOne //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Integer productID;
	
	@Column (name = "Quantity")
	private Integer quantity;
	
	
	
	//GETTERS AND SETTERS
	public Integer getBpID() {
		return bpID;
	}
	public void setBpID(Integer bpID) {
		this.bpID = bpID;
	}
	public Integer getBasketID() {
		return basketID;
	}
	public void setBasketID(Integer basketID) {
		this.basketID = basketID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
