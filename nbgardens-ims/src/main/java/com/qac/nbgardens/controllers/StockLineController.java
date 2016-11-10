
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
	
	
	public ArrayList<StockLine> getStockLines(Integer selectID) 
	{
		stockLines = new ArrayList<StockLine>(stockLineService.findAllCertain(selectID));
		return stockLines;
	}
	
	public Double getStockLinesPrice(Integer selectID) 
	{	
		
			double totalStockOrderPrice = 0;
		
		stockLines = new ArrayList<StockLine>(stockLineService.findAllCertain(selectID));
		
		for (Integer i = 0; i < stockLines.size(); i++ )
		{
			totalStockOrderPrice = totalStockOrderPrice + stockLines.get(i).getPrice();
		}
		
		return totalStockOrderPrice;
	}
}
