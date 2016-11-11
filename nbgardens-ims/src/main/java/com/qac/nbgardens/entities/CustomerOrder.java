package com.qac.nbgardens.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qac.nbgardens.entities.enums.OrderStatus;

//@NamedQueries ({
//	@NamedQuery (
//		name = "findOrderStatus",
//		query = "SELECT * FROM CustomerOrder co where co. = :"
//	)
//})

//SQL table definition
@Entity
@Table (name = "Customer_Order")
public class CustomerOrder {
	
	@Id //ID is for PK
	@Column (name = "Customer_Order_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer customerOrderId;
	
	@OneToOne //For FK.
	@JoinColumn(name="Email", nullable = false)
	@NotNull
	private Customer customer;
	
	@OneToOne //For FK.
	@JoinColumn(name="Address_ID", nullable = false)
	@NotNull
	private Address	address;
	
	
	@Column (name = "Order_Date", nullable = false)
	@NotNull
	private Date orderDate;
	
	@Column (name = "Status", nullable = false, length = 255)
	@NotNull
	private OrderStatus status;
	//End of table definition
	
	//private List<OrderLine> orderLines;
	
	
	
	// Constructors
	public CustomerOrder(){}
	public CustomerOrder(Customer customer, Date orderDate, OrderStatus status, Address address) {

		this.customer = customer;
		this.orderDate = orderDate;
		this.status = status;
		//this.orderLines = new ArrayList<OrderLine>();
		this.address = address;
	}


	
	//GETTERS AND SETTERS
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
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


//	public List<OrderLine> getOrderLines() {
//		return orderLines;
//	}
//
//
//	public void setOrderLines(List<OrderLine> orderLines) {
//		this.orderLines = orderLines;
//	}
//	
//	public void addOrderLine(OrderLine o) {
//		orderLines.add(o);
//	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Integer getCustomerOrderId() {
		return customerOrderId;
	}
	

	
	
	
}
