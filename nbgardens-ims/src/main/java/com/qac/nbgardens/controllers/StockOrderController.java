
package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.service.CustomerService;
import com.qac.nbgardens.service.StockOrderService;
import com.qac.nbgardens.util.Pagination;


@Named("stockorders")
@SessionScoped
public class StockOrderController implements Serializable{ // Need to changeeeeeeeee everything.
	@Inject
	private StockOrderService stockOrderService;
	private ArrayList<StockOrder> stockOrders = null;
	private Pagination pagination;
		

	public ArrayList<StockOrder> getStockOrders() 
	{
		if(stockOrders == null)
			stockOrders = getPagination().createArrayList();
		return stockOrders;
	}
		
	public void stockOrderTest()
	{	 
		 System.out.println("Step 1");
		 System.out.println("Step 2");
		 System.out.println("Step 3");
		 System.out.println("Step 4");
		 
		// System.out.println(customerID +" <-Customer ID || Order Id-> " + orderID);
		 //stockOrderService.displayProductTitleFromSpecificCustomerOrder(customerID, orderID);
	}

	private Pagination getPagination() 
	{
		if(pagination==null)
			pagination = new Pagination(20) {
				
				@Override
				public ArrayList createArrayList() {
					try {
						return new ArrayList<StockOrder>(stockOrderService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ArrayList<StockOrder>(stockOrderService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return stockOrderService.findAll().size();
				}
			};
		return pagination;
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
