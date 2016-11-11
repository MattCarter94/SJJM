package com.qac.nbgardens.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Order_Line")
public class OrderLine {
	
	@Id //ID is for PK
	@OneToMany //For FK.
	@Column (name = "Customer_Order_ID")  
	private CustomerOrder customerOrder;

	@Id //ID is for PK
	@OneToMany //For FK.
	@JoinColumn (name = "Product_Product_ID")  
	private Product product;


	@Column (name = "Quantity", nullable = false)
	@NotNull
	private Integer quantity;
	
	@Column (name = "Price", nullable = false)
	@NotNull
	private double price;
	
	
	
	private final float markup = 1.2f;
	
	public OrderLine(){}
	public OrderLine(CustomerOrder customerOrder, Integer quantity, Product product) {
		this.customerOrder = customerOrder;
		this.quantity = quantity;
		this.price = (product.getPrice() * quantity) * markup;
		this.product = product;
	}

	
	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
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
