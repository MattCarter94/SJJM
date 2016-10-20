package com.nbgardens.net_app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;



@Startup
@Singleton
public class InitialData {
	private List<User> users = new ArrayList<User>();
	private List<Basket> baskets = new ArrayList<Basket>();
	private List<Product> products = new ArrayList<Product>();
	private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	
	@PostConstruct
	public void SetupData() {
		
		//Add users
		addUser(new User("Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", 2, "420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB"));
		addUser(new User("Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", 2, "420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB"));
		addUser(new User("Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", 2, "420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB"));
		addUser(new User("Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", 2, "420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB"));
		
		//Add products
		addProduct(new Product("Green Gnome", new BigDecimal(20.05), "its a gnome", Product.Category.Gnome, "imgurl.png", "tag1, tag2, tag3", 5000, Product.State.Active, new Date()));
		addProduct(new Product("Green Gnome", new BigDecimal(20.05), "its a gnome", Product.Category.Gnome, "imgurl.png", "tag1, tag2, tag3", 5000, Product.State.Active, new Date()));
		addProduct(new Product("Green Gnome", new BigDecimal(20.05), "its a gnome", Product.Category.Gnome, "imgurl.png", "tag1, tag2, tag3", 5000, Product.State.Active, new Date()));
		
		//Add wishlists
		//addWishlist();
		
		//Add stockOrders
		//addStockOrder();
		
		//Add baskets
		//addBasket();
	}
	
	public void addToBasket(Basket b) {
		baskets.add(b);
	}
	public void addUser(User u) {
		users.add(u);
	}
	public void addProduct(Product p) {
		products.add(p);
	}
	public void addWishlist(Wishlist w) {
		wishlists.add(w);
	}
	public void addStockOrders(StockOrder so) {
		stockOrders.add(so);
	}
}
