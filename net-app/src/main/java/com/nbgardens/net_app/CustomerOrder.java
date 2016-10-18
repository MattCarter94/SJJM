package com.nbgardens.net_app;

import java.util.Date;

public class CustomerOrder {
	private enum OrderStatus{
		InProgress, Dispatched
	};
	
	private Integer customerOrderID;
	private Integer basketID;
	private Integer userID;
	private Date orderDate;
	private OrderStatus status;
	
	
	
	
	
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
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
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
