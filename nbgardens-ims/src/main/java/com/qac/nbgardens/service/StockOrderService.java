
package com.qac.nbgardens.service;

//import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.managers.CustomerManager;
import com.qac.nbgardens.managers.StockOrderManager;;

@Stateless
public class StockOrderService 
{
	@Inject
	private StockOrderManager stockOrderManager;

	
	public List<StockOrder> findAll() {
		return stockOrderManager.findAll();
	}


	public void displayProductTitleFromSpecificCustomerOrder(Integer customerID, Integer orderID) {
		// TODO Auto-generated method stub
		
		// This code is here for testing reference. - It basically lets you see any part of a stock order. 
	//	stockOrderManager.getStockOrderDate()
		// The amount of orders customer 0 has
		//System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().size());
		
	}
}
