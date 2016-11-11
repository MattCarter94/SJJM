
package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.service.IncompleteStockOrderService;
import com.qac.nbgardens.service.StockOrderService;



@Named("incompletestockorders")
@SessionScoped
public class InCompleteStockOrderController implements Serializable{ 
	@Inject
	private IncompleteStockOrderService incompleteStockOrderService;
	private ArrayList<StockOrder> incompleteStockOrders = null;		
	
	public ArrayList<StockOrder> getIncompleteOrders() 
	{
		if(incompleteStockOrders == null)
		{
			incompleteStockOrders = new ArrayList<StockOrder>(incompleteStockOrderService.findAllInComplete());
		}
		return incompleteStockOrders;
	}
}
