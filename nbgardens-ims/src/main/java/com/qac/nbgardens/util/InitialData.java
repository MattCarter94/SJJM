package com.qac.nbgardens.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;


import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;



@Startup
@Singleton
public class InitialData {
	private List<Product> products = new ArrayList<Product>();
	//private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	//private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	
	@PostConstruct
	public void SetupData() {
		//Add users

		//Add products
		addProduct(new Product(100, "Green Gnome", new BigDecimal(20.05), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(101, "Blue Gnome", new BigDecimal(300.99), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(102, "Rainbow Gnome", new BigDecimal(908070.50), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));

		//Add wishlists
		//addWishlist();
		
		//Add stockOrders
		//addStockOrder();
		
		//Add baskets
		//addBasket();
	}
	
//	public void addToBasket(Basket b) {
//		baskets.add(b);
//	}
	public void addProduct(Product p) {
		products.add(p);
	}

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}

	public ArrayList<Product> getProducts() {
		
		return (ArrayList<Product>) products;
	}

	public List<StockOrder> getStockOrders() {
		return stockOrders;
	}
	
}