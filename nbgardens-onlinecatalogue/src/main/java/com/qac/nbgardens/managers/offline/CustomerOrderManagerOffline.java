package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.CustomerOrderManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
public class CustomerOrderManagerOffline implements CustomerOrderManager {
	
	@Inject
	private InitialData initialData;
	@Inject
	private UserCredentials userCredentials;
	
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


	@Override
	public CustomerOrder getBasketGivenEmail(String email) {
		List<CustomerOrder> customerOrders = new ArrayList<>(); // Create empty list to contain customer orders
		initialData.getCustomerOrders().forEach(co->{ // Get list of customer orders. For each order in this list...
			if(co.getCustomer().getEmail().equals(email) && co.getStatus().equals(OrderStatus.BASKET)) // If the order has a customer who's id is equal to the one we feed in, and the orders status is set to basket...
//				System.out.println("Found an order with a correct customer email and status of basket");
				customerOrders.add(co); // Add the order we found to the local list created above
		});
		if(customerOrders.size() == 0){
			CustomerOrder cu = new CustomerOrder(userCredentials.getUser(), OrderStatus.BASKET);
			initialData.addCustomerOrder(cu);
			System.out.println("Created a new basket");
			return cu;
		}
		else{
			System.out.println("Existing Basket found");
			return customerOrders.get(0); // Return the first item because it only has one item in it, the order we found and added
//		return null;
		}
	}


	@Override
	public void updateUserBasket(CustomerOrder basket, int idx) {
		initialData.updateCustomerOrder(basket, idx);
	}


	@Override
	public void updateCheckoutBasket(CustomerOrder newBasket, int idx, CustomerOrder basket) {
		initialData.updateCheckoutOrder(newBasket, idx, basket);
	}


	
}
