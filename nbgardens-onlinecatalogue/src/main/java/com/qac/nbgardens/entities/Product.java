package com.qac.nbgardens.entities;


import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;


@NamedQueries ({
	@NamedQuery (
		name = "findProductById",
		query = "SELECT * FROM Product p where p.productID = :productID"
	)
})


//SQL table definition
@Entity
@Table (name = "Product")
public class Product {
	
	private DecimalFormat df = new DecimalFormat("#.00"); 
	
	@Id //ID is for PK
	@Column (name = "Product_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer productID;
	
	@Column (name = "Title", nullable = false, length = 255)
	@NotNull
	private String title;
	
	@Column (name = "Price", nullable = false)
	@NotNull
	private double price;
	
	@Column (name = "Description", nullable = false, length = 1000)
	@NotNull
	private String description;
	
	@Column (name = "Category", nullable = false, length = 255)
	@NotNull
	private Category category;
	
	@Column (name = "Image", nullable = false, length = 255)
	@NotNull
	private String image;
	
	@Column (name = "Tags", nullable = false, length = 255)
	@NotNull
	private String tags;

	@Column (name = "Stock", nullable = false)
	@NotNull
	private Integer stock;
	
	@Column (name = "State", nullable = false, length = 255)
	@NotNull
	private ProductStatus state;
	
	@Column (name = "Order_Date", nullable = false)
	@NotNull
	private Date orderDate;
	//End of table definition
	
	//Constructor
	public Product(){};
	public Product(String title, double price, String description, Category category, String image, String tags, Integer stock, ProductStatus state, Date orderDate){
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
		this.tags = tags;
		this.stock = stock;
		this.state = state;
		this.orderDate = orderDate;
	};
	public Product(Integer id, String title, double price, String description, Category category, String image, String tags, Integer stock, ProductStatus state, Date orderDate){
		this.productID = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
		this.tags = tags;
		this.stock = stock;
		this.state = state;
		this.orderDate = orderDate;
	};
	
	
	//GETTERS AND SETTERS
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public ProductStatus getState() {
		return state;
	}
	public void setState(ProductStatus state) {
		this.state = state;
	}
	
	
}
