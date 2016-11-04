package com.qac.nbgardens.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@NamedQueries ({
	//Update existing stock
	@NamedQuery (
		name = "updateProductById",
		query = "INSERT INTO Product p where p.productID = :productID"
	),
	//Add new product
	@NamedQuery (
		name = "addProductById",
		query = "INSERT INTO Product p VALUES p.title = :title, p.price = :price, p.descrpition = :description, p.category = :category, "
				+ "p.image = :image, p.tags = :tags, p.stock = :stock, p.active = :active"
	)
})

@Entity
@Table (name = "Stock_Order")
public class StockOrder {
	@Id //ID is for PK
	@Column (name = "Stock_Order_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private StockLine stockLine;
	
	@OneToMany //For FK.
	@JoinColumn(name="Supplier_ID", nullable = false)
	@NotNull
	private Supplier supplier;
	
	@Column (name = "Stock_Order_Date")
	private Date stockOrderDate;
	
	@Column (name = "Stock_Received_Date")
	private Date stockRecievedDate;

	public StockOrder(StockLine stockLine, Supplier supplier, Date stockOrderDate, Date stockRecievedDate) {
		this.stockLine = stockLine;
		this.supplier = supplier;
		this.stockOrderDate = stockOrderDate;
		this.stockRecievedDate = stockRecievedDate;
	}
	
	// GETTERS and SETTERS
	
	public StockLine getStockOrderID() {
		return stockLine;
	}

	public StockLine getStockLine() {
		return stockLine;
	}

	public void setStockLine(StockLine stockLine) {
		this.stockLine = stockLine;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getStockOrderDate() {
		return stockOrderDate;
	}

	public void setStockOrderDate(Date stockOrderDate) {
		this.stockOrderDate = stockOrderDate;
	}

	public Date getStockRecievedDate() {
		return stockRecievedDate;
	}

	public void setStockRecievedDate(Date stockRecievedDate) {
		this.stockRecievedDate = stockRecievedDate;
	}

}
