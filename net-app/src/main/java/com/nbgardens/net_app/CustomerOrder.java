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
	
}
