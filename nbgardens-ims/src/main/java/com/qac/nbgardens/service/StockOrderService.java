
package com.qac.nbgardens.service;

//import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.managers.CustomerManager;
import com.qac.nbgardens.managers.StockOrderManager;;

@Stateless
public class StockOrderService 
{
	@Inject
	private StockOrderManager stockOrderManager;
	
	public List<StockOrder> findAll() {
		return stockOrderManager.findAll();
	}
}
