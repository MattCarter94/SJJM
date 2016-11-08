package com.qac.nbgardens.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private Integer stockOrderId;
	
	@OneToMany //For FK.
	@JoinColumn(name="Supplier_ID", nullable = false)
	@NotNull
	private Integer supplierId;
	
	@Column (name = "Stock_Order_Date")
	private Date stockOrderDate;
	
	@Column (name = "Stock_Received_Date")
	private Date stockRecievedDate;

	
	
	private List<StockLine> stockLines;
	
	public StockOrder(){};
	
	
	public StockOrder(Integer supplierId, Date stockOrderDate, Date stockRecievedDate) {
		this.supplierId = supplierId;
		this.stockOrderDate = stockOrderDate;
		this.stockRecievedDate = stockRecievedDate;
		this.stockLines = new ArrayList<StockLine>();
	}
	
	

	public Integer getStockOrderId() {
		return stockOrderId;
	}

	public void setStockOrderId(Integer stockOrderId) {
		this.stockOrderId = stockOrderId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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

	public List<StockLine> getStockLines() {
		return stockLines;
	}

	public void setStockLines(List<StockLine> stockLines) {
		this.stockLines = stockLines;
	}
	
	public void addStockLine(StockLine sl) {
		stockLines.add(sl);
	}

	// GETTERS and SETTERS
	
	

}
