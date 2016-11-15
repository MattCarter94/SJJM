package com.qac.nbgardens.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "Supplier_Product")
public class SupplierProduct {

	
	@Id //ID is for PK
	@OneToOne
	@Column (name = "Supplier_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer supplierID;
	
	@Id // Id is for PK
	@OneToMany //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private Product product;
	
	@Column (name = "PriceForOneUnit", nullable = false)
	@NotNull
	private double priceFor_1_Unit;
	
	@Column (name = "PriceForTenUnits", nullable = false)
	@NotNull
	private double priceFor_10_Unit;
	
	@Column (name = "PriceForHundredUnits", nullable = false)
	@NotNull
	private double priceFor_100_Unit;

	
	//Constructor
	public SupplierProduct(Integer supplierID, Product product, double priceFor_1_Unit,
			double priceFor_10_Unit, double priceFor_100_Unit) {
		this.supplierID = supplierID;
		this.product = product;
		this.priceFor_1_Unit = priceFor_1_Unit;
		this.priceFor_10_Unit = priceFor_10_Unit;
		this.priceFor_100_Unit = priceFor_100_Unit;
	}



	//Getters and Setters
	
	public Integer getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}

	public double getPriceFor_1_Unit() {
		return priceFor_1_Unit;
	}

	public void setPriceFor_1_Unit(double priceFor_1_Unit) {
		this.priceFor_1_Unit = priceFor_1_Unit;
	}

	public double getPriceFor_10_Unit() {
		return priceFor_10_Unit;
	}

	public void setPriceFor_10_Unit(double priceFor_10_Unit) {
		this.priceFor_10_Unit = priceFor_10_Unit;
	}

	public double getPriceFor_100_Unit() {
		return priceFor_100_Unit;
	}

	public void setPriceFor_100_Unit(double priceFor_100_Unit) {
		this.priceFor_100_Unit = priceFor_100_Unit;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
