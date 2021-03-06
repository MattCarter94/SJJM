package com.qac.nbgardens.managers;

import java.util.Date;
import java.util.List;

import com.qac.nbgardens.entities.StockOrder;

public interface IncompleteStockOrdersManager 
{
	
	public Date getStockOrderDate(Integer stockOrderID);
	public Date getstockRecievedDate(Integer stockOrderID);
	public List<StockOrder> findAllInComplete();

}
