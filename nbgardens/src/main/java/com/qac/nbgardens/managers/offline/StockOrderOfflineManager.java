package com.qac.nbgardens.managers.offline;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.managers.StockOrderManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
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
	

