package com.qac.nbgardens.managers;

import java.util.Date;
import java.util.List;

import com.qac.nbgardens.entities.SupplierProduct;

public interface SupplierProductManager {


	public List<SupplierProduct> findAll(Integer supplierID);
	
}
