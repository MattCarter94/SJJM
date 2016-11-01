package com.qac.nbgardens.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.qac.nbgardens.entities.Basket;
import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.User;
import com.qac.nbgardens.entities.Wishlist;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;



@Startup
@Singleton
public class InitialData {
	
	private List<User> users = new ArrayList<User>();
	//private List<Basket> baskets = new ArrayList<Basket>();
	private List<CardDetails> cards = new ArrayList<CardDetails>();
	private List<Product> products = new ArrayList<Product>();
	//private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	//private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<Basket> baskets = new ArrayList<Basket>();
	
	@PostConstruct
	public void SetupData() {
		//Add users
		addUser(new User(new CardDetails("123456789", "2018-05-03"), new Wishlist(new BigDecimal(20.05)), new Basket(new BigDecimal(20.05)), "Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", 2, "420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB"));

		//Add products
		addProduct(new Product("Green Gnome", new BigDecimal(20.05), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product("Green Gnome", new BigDecimal(20.05), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product("Green Gnome", new BigDecimal(20.05), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));

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
	public List<User> getUsers() {
		return users;
	}
	public void addUser(User u) {
		users.add(u);
	}
	public void addProduct(Product p) {
		products.add(p);
	}
	public void addToBasket(Basket b) {
		//stub
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
	
	public List<Basket> getBaskets() {
		// TODO Auto-generated method stub
		return baskets;
	}
}