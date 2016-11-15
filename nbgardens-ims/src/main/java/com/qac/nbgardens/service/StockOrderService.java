
package com.qac.nbgardens.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.managers.CustomerManager;
import com.qac.nbgardens.managers.StockOrderManager;
import com.qac.nbgardens.util.InitialData;;

@Stateless
public class StockOrderService 
{
	@Inject
	private StockOrderManager stockOrderManager;
	@Inject
	InitialData initialData;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	
	public List<StockOrder> findAllComplete() 
	{
		return stockOrderManager.findAllComplete();
	}
	
	public StockOrder findStockOrderById(Integer stockId){
		return stockOrderManager.findById(stockId);
	}

	public void setComplete(Integer stockOrderId) throws ParseException {
		System.out.println("service");
		// Find stock order and set complete to true
		StockOrder so = stockOrderManager.findById(stockOrderId);
		System.out.println("found stock order");
		so.setIsOrderComplete(true);
		so.setStockRecievedDate(sdf.parse("05-11-2016"));
		System.out.println("set to true");
		
		// Update stock order within actual data (initial data)
		initialData.updateStockOrder(so);
	}
	
	
}
