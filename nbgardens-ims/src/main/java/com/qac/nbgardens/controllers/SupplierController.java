
package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.service.StockOrderService;
import com.qac.nbgardens.service.SupplierService;
import com.qac.nbgardens.util.InitialData;


@Named("suppliers")
@SessionScoped
public class SupplierController implements Serializable{ 
	@Inject
	private SupplierService supplierOrderService;
	@Inject
	private StockOrderService stockOrderService;
	
	private ArrayList<Supplier> suppliers = null;	
	private InitialData inData = new InitialData();
	
	private Supplier sup = new Supplier("asdsd");
	
	public ArrayList<Supplier> getSuppliers() 
	{

		if(suppliers == null)
		{
			suppliers = new ArrayList<Supplier>(supplierOrderService.findAll());
		}
		return suppliers;
	}
	
	public void createStockOrder(Integer SupplierId, Integer StockOrderId, Integer ProductId, Integer Quantity)
	{
		ArrayList<Supplier> listOfSuppliers = null;
		ArrayList<StockOrder> listofSuppliersStockOrders = null;
		Integer counter = 0;		
		listOfSuppliers = getSuppliers();
		
		for (Integer i = 0; i < listOfSuppliers.size(); i++)
		{
			if (listOfSuppliers.get(i).getSupplierId() == SupplierId)
			{	
				listofSuppliersStockOrders = (ArrayList<StockOrder>) listOfSuppliers.get(i).getStockOrders();
				if ( listofSuppliersStockOrders.size() > 0)
				{
					for (Integer j = 0; j < listofSuppliersStockOrders.size(); j++ )
					{
						if (listofSuppliersStockOrders.get(j).getStockOrderId() == StockOrderId)
						{
							listofSuppliersStockOrders.get(j).addStockLine(new StockLine(stockOrderService.findStockOrderById(StockOrderId), inData.getProducts().get(ProductId - 999), Quantity));
						}
						
					}
				}
				else
				{
				Boolean isTheOrderComplete;
				Date stockRecievedDate;
				listOfSuppliers.get(i).addStockOrder(new StockOrder());
				}
				
				
			}
		}
		
		//if (counter == 0)
			
	}

}
