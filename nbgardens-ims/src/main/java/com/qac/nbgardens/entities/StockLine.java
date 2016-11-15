package com.qac.nbgardens.entities;


import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class StockLine {
	
	@Id //ID is for PK
	@OneToOne
	@Column (name = "Stock_Order_ID")  
	private StockOrder stockOrder;
	
	@OneToOne //For FK.
	@NotNull
	private Product product;
	
	@Column (name = "Quantity", length = 255)
	private int quantity;
	
	@Column (name = "Price", length = 255)
	private double price;
	
	DecimalFormat df = new DecimalFormat("#.##"); 
	
	public StockLine(){};
	
	public StockLine(StockOrder stockOrder, Product product, int quantity) {
		this.stockOrder = stockOrder;
		this.product = product;
		this.quantity = quantity;
		this.price = Double.valueOf(df.format(product.getPrice() * quantity));
	}



	// Getters and Setters

	public StockOrder getStockOrder() {
		return stockOrder;
	}

	public void setStockOrder(StockOrder stockOrder) {
		this.stockOrder = stockOrder;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
