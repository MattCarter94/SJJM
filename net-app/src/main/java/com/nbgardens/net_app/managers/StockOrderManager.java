package com.nbgardens.net_app.managers;

import java.util.ArrayList;
import java.util.List;

import com.nbgardens.net_app.entities.StockOrder;

public interface StockOrderManager {

	public void persistStockOrder(StockOrder s);
	
	public void persistStockOrders(List<StockOrder> s);
	
	public StockOrder findById(StockOrder id);
	
	public ArrayList<StockOrder> getStockOrders();
	
	public void updateStockOrder(StockOrder s);
	
	public void removeStockOrder(StockOrder s);
	
	
}
