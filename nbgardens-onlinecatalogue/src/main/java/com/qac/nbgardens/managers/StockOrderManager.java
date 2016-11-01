package com.qac.nbgardens.managers;

import java.util.Date;

public interface StockOrderManager {

	public Date getStockOrderDate(Integer stockOrderID);
	public Date getstockRecievedDate(Integer stockOrderID);
	
	
}
