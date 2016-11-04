
package com.qac.nbgardens.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.service.CustomerService;
import com.qac.nbgardens.util.Pagination;


@Named("customers")
@SessionScoped
public class StockOrderController implements Serializable{ // Need to changeeeeeeeee everything.
	@Inject
	private CustomerService customerService;
	private DataModel<Customer> customers = null;
	private Pagination pagination;
		

	public DataModel<Customer> getCustomers() 
	{
		if(customers == null)
			customers = getPagination().createDataModel();
		return customers;
	}
		
	public void getProductTitleFromCustomerOrder(Integer customerID, Integer orderID)
	{	 
		 System.out.println("Step 1");
		 System.out.println(customerID +" <-Customer ID || Order Id-> " + orderID);
		 customerService.displayProductTitleFromSpecificCustomerOrder(customerID, orderID);
	}

	private Pagination getPagination() 
	{
		if(pagination==null)
			pagination = new Pagination(20) 
		{
					
			@Override
			public DataModel createDataModel() 
			{
				try 
				{
					return new ListDataModel<Customer>(customerService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
				} catch (Exception e) 
				{
					return new ListDataModel<Customer>(customerService.findAll().subList(getPageFirstItem(), getItemsCount()));
				}
			}

			@Override
			public int getItemsCount() 
			{
				return customerService.findAll().size();
			}
		};
		return pagination;
	}
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
