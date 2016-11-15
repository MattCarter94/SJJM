package com.qac.nbgardens.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@NotNull
	private Supplier supplier;
	
	@Column (name = "Stock_Order_Date")
	private Date stockOrderDate;
	
	@Column (name = "Stock_Received_Date")
	private Date stockRecievedDate;
	
	@Column (name = "Is_Order_Complete")
	private Boolean isOrderComplete;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="supplier")
	private List<StockLine> stockLines;
	
	
	private static int idCounter = 1;

	
			
	public StockOrder(){};
	
	public StockOrder(Supplier supplier, Date stockOrderDate, Date stockRecievedDate, Boolean isTheOrderComplete) {
		if (this.stockOrderId == null) {
			this.stockOrderId = idCounter;
			idCounter++;
		}
		this.supplier = supplier;
		this.stockOrderDate = stockOrderDate;
		this.stockRecievedDate = stockRecievedDate;
		this.stockLines = new ArrayList<StockLine>();
		this.isOrderComplete = isTheOrderComplete;
	}
	
	
	
	//Getter and Setters

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Boolean getIsOrderComplete() {
		return isOrderComplete;
	}

	public void setIsOrderComplete(Boolean isOrderComplete) {
		this.isOrderComplete = isOrderComplete;
	}

	public Boolean getisOrderComplete() {
		return isOrderComplete;
	}

	public void setStockOrderId(Boolean isOrderComplete) {
		this.isOrderComplete = isOrderComplete;
	}
	
	public Integer getStockOrderId() {
		return stockOrderId;
	}

	public void setStockOrderId(Integer stockOrderId) {
		this.stockOrderId = stockOrderId;
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
