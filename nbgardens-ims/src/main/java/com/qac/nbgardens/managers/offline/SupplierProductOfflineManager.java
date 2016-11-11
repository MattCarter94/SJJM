package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.entities.SupplierProduct;
import com.qac.nbgardens.managers.SupplierManager;
import com.qac.nbgardens.managers.SupplierProductManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
public class SupplierProductOfflineManager implements SupplierProductManager {
	
	@Inject
	private InitialData initialData;
	
	
	@Override
	public List<SupplierProduct> findAll(Integer supplierID) 
	{
		List<SupplierProduct> supplierProducts = initialData.getSupplierProducts();
		return supplierProducts;
	}
}