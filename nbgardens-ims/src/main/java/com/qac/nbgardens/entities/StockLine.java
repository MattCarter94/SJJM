package com.qac.nbgardens.entities;

import java.math.BigDecimal;
import java.util.List;

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
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer stockOrderID;
	
	@Id // Id is for PK
	@OneToMany //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Product product;
	
	@Column (name = "Quantity", length = 255)
	private Integer qty;
	
	@Column (name = "Price", length = 255)
	private BigDecimal price;

	public StockLine(Product product, Integer qty, BigDecimal price) {
		this.product = product;
		this.qty = qty;
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
