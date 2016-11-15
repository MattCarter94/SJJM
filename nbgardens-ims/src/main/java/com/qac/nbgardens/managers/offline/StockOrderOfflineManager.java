package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.Supplier;
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
		List<StockOrder> so = new ArrayList<StockOrder>();
		for (Supplier s : initialData.getSuppliers()) {
			for (int i = 0; i < s.getStockOrders().size(); i++) {
				so.add(s.getStockOrders().get(i));
			}
		}
		
		for(int i=0; i<so.size(); i++){
			if(so.get(i).getStockOrderId().equals(stockOrderID)){
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
		List<StockOrder> so = new ArrayList<StockOrder>();
		for (Supplier s : initialData.getSuppliers()) {
			for (int i = 0; i < s.getStockOrders().size(); i++) {
				so.add(s.getStockOrders().get(i));
			}
		}
		for(int i=0; i<so.size(); i++){
			if(so.get(i).getStockOrderId().equals(stockOrderID)){
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
	
	@Override
	public List<StockOrder> findAllComplete() {
		List<StockOrder> so = new ArrayList<StockOrder>();
		for (Supplier s : initialData.getSuppliers()) 
		{
			for (int i = 0; i < s.getStockOrders().size(); i++) 
			{
					System.out.println("Complete Orders");
					if (s.getStockOrders().get(i).getisOrderComplete() == true)
						so.add(s.getStockOrders().get(i));

			}
		}
		return so;
	}



	@Override
	public StockOrder findById(Integer stockId) {
		List<StockOrder> stockOrders = initialData.getStockOrders();
		StockOrder so = null;
		for(int i=0; i < stockOrders.size(); i++){
			if(stockOrders.get(i).getStockOrderId() == stockId){
				return stockOrders.get(i);
			}
		}
		return null;
	}
}
	

