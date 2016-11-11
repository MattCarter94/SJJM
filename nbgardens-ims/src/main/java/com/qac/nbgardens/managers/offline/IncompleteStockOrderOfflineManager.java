package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.managers.IncompleteStockOrdersManager;
import com.qac.nbgardens.managers.StockOrderManager;
import com.qac.nbgardens.util.InitialData;


@Default
@Stateless
public class IncompleteStockOrderOfflineManager implements IncompleteStockOrdersManager
{
	
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
	
	public List<StockOrder> findAllInComplete() {
		List<StockOrder> so = new ArrayList<StockOrder>();
		for (Supplier s : initialData.getSuppliers()) 
		{
			for (int i = 0; i < s.getStockOrders().size(); i++) 
			{				
					System.out.println("Incomplete Orders");
					if (s.getStockOrders().get(i).getisOrderComplete() == false)
						so.add(s.getStockOrders().get(i));
				
			}
		}
		return so;
	}
}
