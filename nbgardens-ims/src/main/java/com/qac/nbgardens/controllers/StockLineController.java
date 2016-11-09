
package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.service.StockLineService;
import com.qac.nbgardens.util.Pagination;


@Named("stockline")
@SessionScoped
public class StockLineController implements Serializable
{ 
	@Inject
	private StockLineService stockLineService;
	private ArrayList<StockLine> stockLines = null;
	private Pagination pagination;
		

	public ArrayList<StockLine> getStockLines() // run this and choose number to get it going
	{
		if(stockLines == null)
			stockLines = getPagination(1).createArrayList();
		return stockLines;
	}
		
	public void StockLineTest()
	{	 
		 System.out.println("Step 1");
		 System.out.println("Step 2");
		 System.out.println("Step 3");
		 System.out.println("Step 4");
		 
		// System.out.println(customerID +" <-Customer ID || Order Id-> " + orderID);
		// stockOrderService.displayProductTitleFromSpecificCustomerOrder(customerID, orderID);
	}

	private Pagination getPagination(Integer selectID) 
	{
		if(pagination==null)
			pagination = new Pagination(20) {
				
				@Override
				public ArrayList createArrayList() {
					try 
					{
						return new ArrayList<StockLine>(stockLineService.findAll(selectID).subList(getPageFirstItem(), getPageLastItem() + getPageSize()));
						
					} 
					catch (Exception e) 
					{
						return new ArrayList<StockLine>(stockLineService.findAll(selectID).subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return stockLineService.findAll(selectID).size();
				}
			};
		return pagination;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
