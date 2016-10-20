package com.nbgardens.net_app;

import java.math.BigDecimal;
import java.util.Currency;
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
	
	@Id //ID is for PK
	@Column (name = "Product_ID")  
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Product productID;
	
	@Column (name = "Title", nullable = false, length = 255)
	@NotNull
	private String title;
	
	@Column (name = "Price", nullable = false)
	@NotNull
	private BigDecimal price;
	
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
	private State state;
	
	@Column (name = "Order_Date", nullable = false)
	@NotNull
	private Date orderDate;
	//End of table definition
	
	public enum Category{
		Gnome, GnomeAccessory, GardenEquipment
	};
	public enum State{
		Active, Discontinued
	};
	
	
	//Constructor
	public Product(){};
	public Product(String title, BigDecimal price, String description, Category category, String image, String tags, Integer stock, State state, Date orderDate){
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
	public Product getProductID() {
		return productID;
	}
	public void setProductID(Product productID) {
		this.productID = productID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
}
