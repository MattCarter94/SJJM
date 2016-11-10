
package com.qac.nbgardens.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.managers.SupplierManager;


@Stateless
public class SupplierService 
{
	@Inject
	private SupplierManager supplierManager;
	
	public List<Supplier> findAll() {
		return supplierManager.findAll();
	}
}
