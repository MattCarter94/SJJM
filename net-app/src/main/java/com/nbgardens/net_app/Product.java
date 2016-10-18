package com.nbgardens.net_app;

import java.util.Currency;

public class Product {
	private enum Category{
		Gnome, GnomeAccessory, GardenEquipment
	};
	private enum State{
		Active, Discontinued
	};
	
	private Integer productID;
	private String title;
	private Currency price;
	private String description;
	private Category category;
	private String image;
	private String[] tags;
	private Integer stock;
	private State state;
	
	
	
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
	public Currency getPrice() {
		return price;
	}
	public void setPrice(Currency price) {
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
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
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
