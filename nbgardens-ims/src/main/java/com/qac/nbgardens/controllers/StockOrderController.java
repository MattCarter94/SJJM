
package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.text.ParseException;
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
import com.qac.nbgardens.util.InitialData;
import com.qac.nbgardens.util.Pagination;


@Named("stockorders")
@SessionScoped
public class StockOrderController implements Serializable{ 
	@Inject
	private StockOrderService stockOrderService;
	private ArrayList<StockOrder> stockOrders = null;	
	
	private Integer completeId = 0;
	private Integer test = 0;

	public ArrayList<StockOrder> getStockOrders() 
	{
		if(stockOrders == null)
		{
			stockOrders = new ArrayList<StockOrder>(stockOrderService.findAllComplete());
		}
		return stockOrders;
	}
	
	public void setComplete(Integer stockOrderId) throws ParseException{
		System.out.println("controller");
//		Integer stockOrderId = completeId;
		System.out.println(stockOrderId);
		stockOrderService.setComplete(stockOrderId);
	}

	public Integer getCompleteId() {
		return completeId;
	}

	public void setCompleteId(Integer completeId) {
		this.completeId = completeId;
	}

	public void setStockOrders(ArrayList<StockOrder> stockOrders) {
		this.stockOrders = stockOrders;
	}
	
	public void testButton(){
		this.test = 1;
	}

	public Integer getTest() {
		return test;
	}

	public void setTest(Integer test) {
		this.test = test;
	}
	
	
}
