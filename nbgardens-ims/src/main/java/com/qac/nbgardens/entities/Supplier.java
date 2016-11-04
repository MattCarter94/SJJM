package com.qac.nbgardens.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Supplier {

	@Id //ID is for PK
	@Column (name = "Supplier_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private SupplierProducts supplier_ID;
	
	@Column (name = "Supplier Name", nullable = false)
	@NotNull
	private String supplierName;
	
	@Column (name = "SupplierProducts")
	private List<SupplierProducts> supplierProducts = new ArrayList<SupplierProducts>();

	
	//Constructors
	public Supplier( String supplierName) {
		this.supplierName = supplierName;
	}
	
	
	public void addSupplierProduct(SupplierProducts sp) {
		supplierProducts.add(sp);
	}
	

	//GETTERS and SETTERS
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
