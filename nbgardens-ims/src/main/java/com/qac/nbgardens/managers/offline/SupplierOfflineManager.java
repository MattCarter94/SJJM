package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Supplier;

import com.qac.nbgardens.managers.SupplierManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
public class SupplierOfflineManager implements SupplierManager {
	
	@Inject
	private InitialData initialData;
	
	
	@Override
	public List<Supplier> findAll() {
		List<Supplier> supplier = new ArrayList<Supplier>();
		for (Supplier s : initialData.getSuppliers()) 
		{
			supplier.add(s);
		}
		return supplier;
	}
}
	

