package com.qac.nbgardens.entities;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class OrderLine {
	
	@Id
	@OneToMany // Many order lines can be linked to one customer order
	@JoinColumn
	private CustomerOrder customerOrder;

	@Column (name = "Product", nullable = false)
	@NotNull
	private Product product;
	
	@OneToMany
	@Column (name = "Quantity", nullable = false)
	@NotNull
	private int quantity; // The quantity of that specific product
	
	@Column (name = "Price", nullable = false)
	@NotNull
	private double price;

	private final float markup = 1.2f;
	
	
	public OrderLine(CustomerOrder customerOrder, Product product, int quantity) {
		this.customerOrder = customerOrder;
		this.product = product;
		this.quantity = quantity;
		this.price = product.getPrice()*quantity;
//		this.price = (product.getPrice() * quantity) * markup;
	}

	
	
	//Getter and Setters

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

	public float getMarkup() {
		return markup;
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
