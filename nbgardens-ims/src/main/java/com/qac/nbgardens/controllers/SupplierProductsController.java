
package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;


import com.qac.nbgardens.entities.SupplierProduct;
import com.qac.nbgardens.service.SupplierProductService;


@Named("supplierproducts")
@SessionScoped
public class SupplierProductsController implements Serializable{ 
	@Inject
	private SupplierProductService supplierProductService;
	private ArrayList<SupplierProduct> supplierProducts = null;		

	public ArrayList<SupplierProduct> getSuppliersProducts(Integer supplierID) 
	{

		System.out.println("Passed in Value is: " + supplierID);
		
			supplierProducts = new ArrayList<SupplierProduct>(supplierProductService.findAll(supplierID));
		
		return supplierProducts;
	}

}
