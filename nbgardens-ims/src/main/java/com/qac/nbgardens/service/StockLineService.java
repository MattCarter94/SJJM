package com.qac.nbgardens.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;


import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.managers.StockLineManager;



@Stateless
public class StockLineService 
{
	@Inject
	private StockLineManager stockLineManager;

	
	public List<StockLine> findAllCertain(Integer selectID) 
	{
		return stockLineManager.findAllCertain(selectID);
	}
	
}
