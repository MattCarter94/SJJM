package com.qac.nbgardens.entities;


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
	private Integer customerOrderID;

	@Id //ID is for PK
	@OneToMany //For FK.
	@JoinColumn (name = "Product_ID")  
	private Integer productId;


	@Column (name = "Quantity", nullable = false)
	@NotNull
	private Integer quantity;
	
	@Column (name = "Price", nullable = false)
	@NotNull
	private double price;
	
	
	private Product product;
	private final float markup = 1.2f;
	
	
	public OrderLine(Integer customerOrderID, Integer productId, Integer quantity, Product product) {
		this.customerOrderID = customerOrderID;
		this.productId = productId;
		this.quantity = quantity;
		this.price = (product.getPrice() * quantity) * markup;
		this.product = product;
	}

	
	
	public Integer getCustomerOrderID() {
		return customerOrderID;
	}

	public void setCustomerOrderID(Integer customerOrderID) {
		this.customerOrderID = customerOrderID;
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
