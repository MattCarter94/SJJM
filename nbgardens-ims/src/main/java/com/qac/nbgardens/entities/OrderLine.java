package com.qac.nbgardens.entities;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class OrderLine {
	
	@Id //ID is for PK
	@OneToMany //For FK.
	@Column (name = "Customer_Order_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer customerOrderID;

	@Id //ID is for PK
	@OneToMany //For FK.
	@JoinColumn (name = "Product_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Product product;

	@Column (name = "Quantity", nullable = false)
	@NotNull
	private Integer quantity;
	
	@Column (name = "Price", nullable = false)
	@NotNull
	private BigDecimal price;
	
	public OrderLine(Integer customerOrderID, Product product, Integer quantity, BigDecimal price) {
		
		this.customerOrderID = customerOrderID;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getCustomerOrderID() {
		return customerOrderID;
	}

	public void setCustomerOrderID(Integer customerOrderID) {
		this.customerOrderID = customerOrderID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
