package com.nbgardens.net_app.managers;

import java.util.Date;
import com.nbgardens.net_app.entities.enums.OrderStatus;

public interface CustomerOrderManager {

	public Date returnOrderDate(Integer customerOrderID);
	public OrderStatus findOrderStatus(Integer customerOrderID);
		
}
