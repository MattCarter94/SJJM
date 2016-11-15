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
		
		for (Integer j = 0; j < initialData.getSuppliers().size(); j++)
		{
			for (StockOrder so : initialData.getSuppliers().get(j).getStockOrders()) 
			{
				for (int i = 0; i < so.getStockLines().size(); i++) 
				{	
					if (so.getStockLines().get(i).getStockOrder().getStockOrderId() == selectID)
						sl.add(so.getStockLines().get(i));
				}
			}
		}
		return sl;
	}


}