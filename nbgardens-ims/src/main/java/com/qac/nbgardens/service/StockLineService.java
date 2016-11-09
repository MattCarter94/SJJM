package com.qac.nbgardens.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;


import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.managers.StockLineManager;



@Stateless
public class StockLineService 
{
	@Inject
	private StockLineManager stockLineManager;

	
	public List<StockLine> findAll(Integer selectID) 
	{
		return stockLineManager.findAll(selectID);
	}


	public void displayProductTitleFromSpecificCustomerOrder(Integer customerID, Integer orderID) 
	{
		// TODO Auto-generated method stub
		// This code is here for testing reference. - It basically lets you see any part of a stock order. 
		//	stockOrderManager.getStockOrderDate()
		// The amount of orders customer 0 has
		//System.out.println(customerManager.getCustomers().get(0).getCustomerOrders().size());
		
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
