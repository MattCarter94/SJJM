
package com.qac.nbgardens.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.SupplierProduct;
import com.qac.nbgardens.managers.SupplierProductManager;



@Stateless
public class SupplierProductService 
{
	@Inject
	private SupplierProductManager supplierProductManager;
	
	public List<SupplierProduct> findAll(Integer supplierID) {
		return supplierProductManager.findAll(supplierID);
	}
}
