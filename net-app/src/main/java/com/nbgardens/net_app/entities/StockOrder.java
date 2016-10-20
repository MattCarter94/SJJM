package com.nbgardens.net_app.entities;

import java.util.Currency;
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
	private Integer stockOrderID;
	
	@OneToMany //For FK.
	@JoinColumn(name="Product_ID", nullable = false)
	@NotNull
	private List<Product> product;
	
	@Column (name = "Supplier", length = 255)
	private String supplier;
	
	@Column (name = "Quantity", length = 255)
	private Integer quantity;
	
	@Column (name = "Total_Price")
	private Currency totalPrice;
	
	@Column (name = "Stock_Order_Date")
	private Date stockOrderDate;
	
	@Column (name = "Stock_Received_Date")
	private Date stockRecievedDate;
	
	
	public StockOrder() {}
	public StockOrder(List<Product> productID,
			String supplier, Integer quantity, Date stockOrderDate,
			Date stockRecievedDate) {
		super();
		this.product = productID;
		this.supplier = supplier;
		this.quantity = quantity;
		this.stockOrderDate = stockOrderDate;
		this.stockRecievedDate = stockRecievedDate;
		//TODO TOTALPRICE
	}
	
	
	
	
	//GETTERS AND SETTERS
	public Integer getStockOrderID() {
		return stockOrderID;
	}
	public void setStockOrderID(Integer stockOrderID) {
		this.stockOrderID = stockOrderID;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Currency getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Currency totalPrice) {
		this.totalPrice = totalPrice;
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
	public List<Product> getProductID() {
		return product;
	}
	public void setProductID(List<Product> productID) {
		this.product = productID;
	}

}
