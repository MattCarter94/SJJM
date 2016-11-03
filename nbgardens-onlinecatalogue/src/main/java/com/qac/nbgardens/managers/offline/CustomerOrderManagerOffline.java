package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.CustomerOrderManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
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


	@Override // Return the customer order from the data that is associated with the id we input and whose status is basket
	public CustomerOrder getBasketGivenUser(Integer userID) {
		List<CustomerOrder> customerOrders = new ArrayList<>(); // Create empty list to contain customer orders
		initialData.getCustomerOrders().forEach(customerOrder->{ // Get list of customer orders. For each order in this list...
			if(customerOrder.getCustomer().getUserID().equals(userID) && customerOrder.getStatus().equals(OrderStatus.BASKET)) // If the order has a customer who's id is equal to the one we feed in, and the orders status is set to basket...
				customerOrders.add(customerOrder); // Add the order we found to the local list created above
		});
		return customerOrders.get(0); // Return the first item because it only has one item in it, the order we found and added
	}
}
