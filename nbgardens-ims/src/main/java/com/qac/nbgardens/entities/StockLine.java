package com.qac.nbgardens.entities;


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
	private Integer stockOrderID;
	
	@Id // Id is for PK
	@OneToOne //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Integer productId;
	
	@Column (name = "Quantity", length = 255)
	private Integer quantity;
	
	@Column (name = "Price", length = 255)
	private double price;
	
	
	private Product product;
	
	
	
	public StockLine(Integer stockOrderID, Integer productId, Integer quantity, Product product) {
		this.stockOrderID = stockOrderID;
		this.productId = productId;
		this.quantity = quantity;
		this.price = product.getPrice() * quantity;
		this.product = product;
	}



	public Integer getStockOrderID() {
		return stockOrderID;
	}

	public void setStockOrderID(Integer stockOrderID) {
		this.stockOrderID = stockOrderID;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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
