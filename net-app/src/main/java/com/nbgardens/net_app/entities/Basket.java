package com.nbgardens.net_app.entities;

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
@Table (name = "Basket")
public class Basket {
	@Id //ID is for PK
	@Column (name = "Basket_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer basketID;
	
	
	@OneToOne //For FK.
	@JoinColumn(name="User_ID", nullable = false)
	@NotNull
	private User userID;
	
	@Column (name = "Total_Price")
	private Currency totalPrice;
	
	
	
	
	public Basket(){};
	public Basket(User userId, Currency totalPrice){
		this.userID = userId;
		this.totalPrice = totalPrice;
	}
	
	
	
	//GETTERS AND SETTERS
	public Integer getBasketID() {
		return basketID;
	}
	public void setBasketID(Integer basketID) {
		this.basketID = basketID;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	public Currency getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Currency totalPrice) {
		this.totalPrice = totalPrice;
	}
}