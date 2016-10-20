package com.nbgardens.net_app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nbgardens.net_app.entities.enums.OrderStatus;

//SQL table definition
@Entity
@Table (name = "Customer_Order")
public class CustomerOrder {
	
	@Id //ID is for PK
	@Column (name = "Customer_Order_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer customerOrderID;
	
	
	@OneToOne //For FK.
	@JoinColumn(name="User_ID", nullable = false)
	@NotNull
	private User userID;
	
	@OneToOne //For FK.
	@JoinColumn(name="Basket_ID", nullable = false)
	@NotNull
	private Integer basketID;
	
	@Column (name = "Order_Date", nullable = false)
	@NotNull
	private Date orderDate;
	
	@Column (name = "Order_Status", nullable = false, length = 255)
	@NotNull
	private OrderStatus status;
	//End of table definition

	public CustomerOrder() {}
	public CustomerOrder(User userID, Integer basketID, Date orderDate,
			OrderStatus status) {
		super();
		this.userID = userID;
		this.basketID = basketID;
		this.orderDate = orderDate;
		this.status = status;
	}



	//GETTERS AND SETTERS
	public Integer getCustomerOrderID() {
		return customerOrderID;
	}
	public void setCustomerOrderID(Integer customerOrderID) {
		this.customerOrderID = customerOrderID;
	}
	public Integer getBasketID() {
		return basketID;
	}
	public void setBasketID(Integer basketID) {
		this.basketID = basketID;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
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
