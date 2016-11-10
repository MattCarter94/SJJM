
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
public class StockOrderController implements Serializable{ 
	@Inject
	private StockOrderService stockOrderService;
	private ArrayList<StockOrder> stockOrders = null;		

	public ArrayList<StockOrder> getStockOrders() 
	{

		if(stockOrders == null)
		{
			stockOrders = new ArrayList<StockOrder>(stockOrderService.findAll());
		}
		return stockOrders;
	}

}
