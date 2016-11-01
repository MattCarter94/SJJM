package com.qac.nbgardens.managers;

import java.util.Date;

import com.qac.nbgardens.entities.enums.OrderStatus;

public interface CustomerOrderManager {

	public Date returnOrderDate(Integer customerOrderID);
	public OrderStatus findOrderStatus(Integer customerOrderID);
		
}
