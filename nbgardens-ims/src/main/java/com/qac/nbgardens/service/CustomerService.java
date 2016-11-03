
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
		
		String plz  = customerManager.getCustomers().get(0).getCustomerOrders().get(0).getCustomerOrderID().getProduct().getTitle();
		System.out.println(plz);
	}
}
