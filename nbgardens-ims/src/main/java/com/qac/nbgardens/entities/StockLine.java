package com.qac.nbgardens.entities;


import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Stock_Line")
public class StockLine {
	
	@Id //ID is for PK
	@OneToOne
	@Column (name = "Stock_Order_ID")  
	private StockOrder stockOrder;
	
	@Id // Id is for PK
	@OneToOne //For FK.
	@JoinColumn(name="Product_Product_ID", nullable = false)
	@NotNull
	private Product product;
	
	@Column (name = "Quantity", length = 255)
	private Integer quantity;
	
	@Column (name = "Price", length = 255)
	private double price;
	
	DecimalFormat df = new DecimalFormat("#.##"); 
	
	
	
	public StockLine(){};
	
	public StockLine(StockOrder stockOrder, Integer quantity, Product product) {
		this.stockOrder = stockOrder;
		this.quantity = quantity;
		this.price = Double.valueOf(df.format(product.getPrice() * quantity));
		this.product = product;
	}



	public StockOrder getStockOrder() {
		return stockOrder;
	}

	public void setStockOrderID(StockOrder stockOrder) {
		this.stockOrder = stockOrder;
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
