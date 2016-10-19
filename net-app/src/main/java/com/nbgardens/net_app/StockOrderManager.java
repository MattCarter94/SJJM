package com.nbgardens.net_app;

import java.util.ArrayList;
import java.util.List;

public interface StockOrderManager {

	public void persistStockOrder(StockOrder s);
	
	public void persistStockOrders(List<StockOrder> s);
	
	public StockOrder findById(Integer id);
	
	public ArrayList<StockOrder> getStockOrders();
	
	public void updateStockOrder(StockOrder s);
	
	public void removeStockOrder(StockOrder s);
	
	
}
