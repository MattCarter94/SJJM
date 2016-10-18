package com.nbgardens.net_app;

import java.util.Currency;

public class Basket {
	private Integer basketID;
	private Integer userID;
	private Currency totalPrice;
	
	
	
	//GETTERS AND SETTERS
	public Integer getBasketID() {
		return basketID;
	}
	public void setBasketID(Integer basketID) {
		this.basketID = basketID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Currency getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Currency totalPrice) {
		this.totalPrice = totalPrice;
	}
}
