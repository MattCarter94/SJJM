package com.nbgardens.net_app.managers.offline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.CustomerOrder;
import com.nbgardens.net_app.entities.User;
import com.nbgardens.net_app.entities.enums.OrderStatus;
import com.nbgardens.net_app.managers.CustomerOrderManager;
import com.nbgardens.net_app.util.InitialData;

public class CustomerOrderManagerOffline implements CustomerOrderManager {
	
	@Inject
	private InitialData initialData;
	
	@Override
	public Date returnOrderDate(Integer customerOrderID){
		int count = 0;
		Date orderDate;
		List<CustomerOrder> co = initialData.getCustomerOrders();
		for(int i=0; i<co.size(); i++){
			if(co.get(i).getCustomerOrderID().equals(customerOrderID)){
				orderDate = co.get(i).getOrderDate();
				count++;
				return orderDate;
			}
		}
		if(count==0){
			System.out.println("No order with that ID found");
		}
		return null;
	}
	
	
	@Override
	public OrderStatus findOrderStatus(Integer customerOrderID){
		int count = 0;
		OrderStatus orderStatus;
		List<CustomerOrder> co = initialData.getCustomerOrders();
		for(int i=0; i<co.size(); i++){
			if(co.get(i).getCustomerOrderID().equals(customerOrderID)){
				orderStatus = co.get(i).getStatus();
				count++;
				return orderStatus;
			}
		}
		if(count==0){
			System.out.println("No order with that ID found");
		}
		return null;
	}
	
	
}
