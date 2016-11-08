package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.service.CustomerService;
import com.qac.nbgardens.util.Pagination;


@Named("customers")
@SessionScoped
public class CustomerController implements Serializable{
	@Inject
	private CustomerService customerService;
	private ArrayList<Customer> customers = null;
	private Pagination pagination;
	

	public ArrayList<Customer> getCustomers() 
	{
		if(customers == null)
			customers = getPagination().createArrayList();
		return customers;
	}
	
	public void getProductTitleFromCustomerOrder()
	{	 
		 System.out.println("Step 1");
		 customerService.displayProductTitleFromSpecificCustomerOrder();
	}

	private Pagination getPagination() 
	{
		if(pagination==null)
			pagination = new Pagination(20) {
				
				@Override
				public ArrayList<Customer> createArrayList() {
					try {
						return new ArrayList<Customer>(customerService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ArrayList<Customer>(customerService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return customerService.findAll().size();
				}
			};
		return pagination;
	}
}

