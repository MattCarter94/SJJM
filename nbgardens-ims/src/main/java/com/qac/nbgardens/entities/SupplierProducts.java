package com.qac.nbgardens.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class SupplierProducts {

	
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
	private BigDecimal priceFor_1_Unit;
	
	@Column (name = "PriceForTenUnits", nullable = false)
	@NotNull
	private BigDecimal priceFor_10_Unit;
	
	@Column (name = "PriceForHundredUnits", nullable = false)
	@NotNull
	private BigDecimal priceFor_100_Unit;

	public SupplierProducts(Product product, BigDecimal priceFor_1_Unit, BigDecimal priceFor_10_Unit,
			BigDecimal priceFor_100_Unit) {
		this.product = product;
		this.priceFor_1_Unit = priceFor_1_Unit;
		this.priceFor_10_Unit = priceFor_10_Unit;
		this.priceFor_100_Unit = priceFor_100_Unit;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getPriceFor_1_Unit() {
		return priceFor_1_Unit;
	}

	public void setPriceFor_1_Unit(BigDecimal priceFor_1_Unit) {
		this.priceFor_1_Unit = priceFor_1_Unit;
	}

	public BigDecimal getPriceFor_10_Unit() {
		return priceFor_10_Unit;
	}

	public void setPriceFor_10_Unit(BigDecimal priceFor_10_Unit) {
		this.priceFor_10_Unit = priceFor_10_Unit;
	}

	public BigDecimal getPriceFor_100_Unit() {
		return priceFor_100_Unit;
	}

	public void setPriceFor_100_Unit(BigDecimal priceFor_100_Unit) {
		this.priceFor_100_Unit = priceFor_100_Unit;
	}
	
}
