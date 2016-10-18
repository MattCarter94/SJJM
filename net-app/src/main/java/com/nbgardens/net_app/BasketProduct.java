package com.nbgardens.net_app;

public class BasketProduct {
	private Integer bpID;
	private Integer basketID;
	private Integer productID;
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
