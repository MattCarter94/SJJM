package com.qac.nbgardens.entities;

import java.util.Date;

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

import com.qac.nbgardens.entities.enums.OrderStatus;

//SQL table definition
@Entity
@Table (name = "Customer_Order")
public class CustomerOrder {
	
	@Id //ID is for PK
	@Column (name = "Customer_Order")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private OrderLine customerOrder;
	
	@OneToOne //For FK.
	@JoinColumn(name="Email", nullable = false)
	@NotNull
	private Customer email;
	
	@OneToMany //For FK.
	@JoinColumn(name="AddressID", nullable = false)
	@NotNull
	private Address												
	addressID;
	
	@Column (name = "Order_Date", nullable = false)
	@NotNull
	private Date orderDate;
	
	@Column (name = "Order_Status", nullable = false, length = 255)
	@NotNull
	private OrderStatus status;
	//End of table definition

	// Constructors
	public CustomerOrder() {}
	
	public CustomerOrder(OrderLine customerOrder, String email, Date orderDate, OrderStatus status) {
		
		this.orderDate = orderDate;
		this.status = status;
	}



	//GETTERS AND SETTERS
	public OrderLine getCustomerOrderID() {
		return customerOrder;
	}
	public void setCustomerOrderID(OrderLine customerOrderID) {
		this.customerOrder = customerOrderID;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
}
