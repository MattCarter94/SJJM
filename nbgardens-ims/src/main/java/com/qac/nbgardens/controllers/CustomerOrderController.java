package com.qac.nbgardens.controllers;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;


import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.service.CustomerOrderService;

import com.qac.nbgardens.util.Pagination;


@Named("customerOrders")
@SessionScoped
public class CustomerOrderController implements Serializable{
	@Inject
	private CustomerOrderService customerOrderService;
	private DataModel<CustomerOrder> customerOrders = null;
	private Pagination pagination;
	
//	public String next() {
//		getPagination().nextPage();
//		recreateModel();
//		return "customers";
//	}
//	
//	public String previous() {
//		getPagination().previousPage();
//		recreateModel();
//		return "customers";	
//	}
	
//	private void recreateModel() {
//		pro = null;
//	}
//
	public DataModel<CustomerOrder> getCustomerOrders() 
	{
		if(customerOrders == null)
			customerOrders = getPagination().createDataModel();
		return customerOrders;
	}

	private Pagination getPagination() 
	{
		if(pagination==null)
			pagination = new Pagination(20) {
				
				@Override
				public DataModel createDataModel() {
					try {
						return new ListDataModel<CustomerOrder>(customerOrderService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<CustomerOrder>(customerOrderService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return customerOrderService.findAll().size();
				}
			};
		return pagination;
	}
}

