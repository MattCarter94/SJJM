
package com.qac.nbgardens.service;

//import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.CustomerManager;;

@Stateless
public class CustomerService 
{
	@Inject
	private CustomerManager customerManager;

	public List<Customer> findAll() 
	{
		return customerManager.findAll();
	}


	public void displayProductTitleFromSpecificCustomerOrder(Integer customerID, Integer orderID) {
		// TODO Auto-generated method stub
		
		// This code is here for testing reference. - It basically lets you see any part of a stock order. 
		
		// The amount of orders customer 0 has
		System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().size());
		
		// Gets customer 0's order date
		System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().get(0).getOrderDate());
		
		// Get Customers Email
		System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().get(0).getEmail());
		
		// get Order Quantity of customer 0's 1st order (element 0 in the list).
		System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().get(0).getCustomerOrderID().getQuantity());
		
		// Get Product
		System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().get(0).getCustomerOrderID().getProduct().getTitle());
		
		// Get Supplier
		//System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().get(0).getCustomerOrderID().getProduct().getTitle());
	}
}
