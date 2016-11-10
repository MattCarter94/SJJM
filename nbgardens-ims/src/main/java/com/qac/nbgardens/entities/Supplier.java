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
	private Integer supplierId;
	
	@Column (name = "Supplier Name", nullable = false)
	@NotNull
	private String supplierName;
	
	
	private List<StockOrder> stockOrders;
	private List<SupplierProduct> supplierProducts;
	
	
	
	public Supplier(String supplierName) {
		super();
		this.supplierName = supplierName;
		this.stockOrders = new ArrayList<StockOrder>();
		this.supplierProducts = new ArrayList<SupplierProduct>();
	}



	public Integer getSupplierId() {
		return supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<StockOrder> getStockOrders() {
		return stockOrders;
	}

	public void setStockOrders(List<StockOrder> stockOrders) {
		this.stockOrders = stockOrders;
	}
	
	public void addStockOrder(StockOrder so) {
		stockOrders.add(so);
	}

	public List<SupplierProduct> getSupplierProducts() {
		return supplierProducts;
	}

	public void setSupplierProducts(List<SupplierProduct> supplierProducts) {
		this.supplierProducts = supplierProducts;
	}
	
	public void addSupplierProducts(SupplierProduct sp) {
		supplierProducts.add(sp);
	}

}
