package com.qac.nbgardens.service;

//import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.managers.IncompleteStockOrdersManager;


@Stateless
public class IncompleteStockOrderService 
{
	@Inject
	private IncompleteStockOrdersManager incompleteStockOrderManager ;
	
	public List<StockOrder> findAllInComplete() 
	{
		return incompleteStockOrderManager.findAllInComplete();
	}
}


