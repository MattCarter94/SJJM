package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.managers.StockLineManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
public class StockLineManagerOffline implements StockLineManager 
{
	
	@Inject
	private InitialData initialData;

	@Override
	public List<StockLine> findAllCertain(Integer selectID) 
	{
		List<StockLine> sl = new ArrayList<StockLine>();
		
		for (StockLine line : initialData.getStockLines()) 
		{
			if (line.getStockOrder().getStockOrderId() == selectID)
				sl.add(line);
		}

		return sl;
	}


}