package com.nbgardens.net_app;

import java.util.Currency;
import java.util.Date;
import java.util.List;

public class StockOrder {
	private Integer stockOrderID;
	private Integer productID;
	private String supplier;
	private Integer quantity;
	private Currency totalPrice;
	private Date stockOrderDate;
	private Date stockRecievedDate;
	private List<Product> products;
	
	
	
	
	//GETTERS AND SETTERS
	public Integer getStockOrderID() {
		return stockOrderID;
	}
	public void setStockOrderID(Integer stockOrderID) {
		this.stockOrderID = stockOrderID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Currency getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Currency totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getStockOrderDate() {
		return stockOrderDate;
	}
	public void setStockOrderDate(Date stockOrderDate) {
		this.stockOrderDate = stockOrderDate;
	}
	public Date getStockRecievedDate() {
		return stockRecievedDate;
	}
	public void setStockRecievedDate(Date stockRecievedDate) {
		this.stockRecievedDate = stockRecievedDate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
