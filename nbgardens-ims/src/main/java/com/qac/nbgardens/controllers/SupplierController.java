
package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.service.SupplierService;


@Named("suppliers")
@SessionScoped
public class SupplierController implements Serializable{ 
	@Inject
	private SupplierService supplierOrderService;
	private ArrayList<Supplier> suppliers = null;		

	public ArrayList<Supplier> getSuppliers() 
	{

		if(suppliers == null)
		{
			suppliers = new ArrayList<Supplier>(supplierOrderService.findAll());
		}
		return suppliers;
	}

}
