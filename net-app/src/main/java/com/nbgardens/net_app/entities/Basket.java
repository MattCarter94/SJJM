package com.nbgardens.net_app.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Basket")
public class Basket {
	@Id //ID is for PK
	@Column (name = "Basket_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer basketID;
	
	@Column (name = "Total_Price")
	private BigDecimal totalPrice;
	
	
	
	public Basket(){};
	public Basket(BigDecimal totalPrice){
		this.totalPrice = totalPrice;
	}
	
	
	
	//GETTERS AND SETTERS
	public Integer getBasketID() {
		return basketID;
	}
	
	public void setBasketID(Integer basketID) {
		this.basketID = basketID;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
}
