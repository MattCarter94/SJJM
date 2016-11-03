package com.qac.nbgardens.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class OrderLine {
	@Id
	@OneToMany // Many order lines can be linked to one customer order
	@JoinColumn
	private CustomerOrder customerOrder;
	
	@Id
	@OneToMany
	private Product product; // Each order line contains a single product
	
	private int quantity; // The quantity of that specific product
	
	private BigDecimal price;

	// Constructor
	public OrderLine(CustomerOrder customerOrder, Product product, int quantity) {
		setCustomerOrder(customerOrder);
		this.product = product;
		this.quantity = quantity;
	}
	
	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}
	
	
	public void setCustomerOrder(CustomerOrder customerOrder) {
		if(!customerOrder.getOrderLines().contains(this)) // if the customer order we pass in does not contain the current order line...
			customerOrder.addOrderLine(this); // add this order line to the customer order's list of order lines
		this.customerOrder = customerOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
}