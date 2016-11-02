package com.qac.nbgardens.managers;

import java.util.Date;
import java.util.List;

import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;

public interface CustomerOrderManager {

	public Date returnOrderDate(Integer customerOrderID);
	public OrderStatus findOrderStatus(Integer customerOrderID);
	public List<CustomerOrder> findAll();
		
}
