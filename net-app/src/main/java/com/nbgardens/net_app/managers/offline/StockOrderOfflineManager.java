package com.nbgardens.net_app.managers.offline;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.StockOrder;
import com.nbgardens.net_app.managers.StockOrderManager;
import com.nbgardens.net_app.util.InitialData;

public class StockOrderOfflineManager implements StockOrderManager {
	
	@Inject
	private InitialData initialData;
	
	@Override
	public Date getStockOrderDate(Integer stockOrderID){
		int count = 0;
		Date stockOrderDate;
		List<StockOrder> so = initialData.getStockOrders();
		for(int i=0; i<so.size(); i++){
			if(so.get(i).getStockOrderID().equals(stockOrderID)){
				stockOrderDate = so.get(i).getStockOrderDate();
				count++;
				return stockOrderDate;
			}
		}
		if(count==0){
			System.out.println("No Stock Order with that ID found");
		}
		return null;
	}
	
	
	
	@Override
	public Date getstockRecievedDate(Integer stockOrderID){
		int count = 0;
		Date recievedDate;
		List<StockOrder> so = initialData.getStockOrders();
		for(int i=0; i<so.size(); i++){
			if(so.get(i).getStockOrderID().equals(stockOrderID)){
				recievedDate = so.get(i).getStockRecievedDate();
				count++;
				return recievedDate;
			}
		}
		if(count==0){
			System.out.println("No Stock Order with that ID found");
		}
		return null;
	}
	
	
	
}
	

