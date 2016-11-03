package com.qac.nbgardens.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.Wishlist;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;



@Startup
@Singleton
public class InitialData {
	private List<Product> products = new ArrayList<Product>();
	//private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	//private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	
	private List<Customer> users = new ArrayList<Customer>();
	private List<CardDetails> cards = new ArrayList<CardDetails>();
	
	
	@PostConstruct
	public void SetupData() {
		//Add users
		addUser(new Customer(new CardDetails("123456789", "2018-05-03"), new Wishlist(new BigDecimal(20.05)), "Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", 2, "420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB"));


		//Add products
		addProduct(new Product(100, "Green Gnome", new BigDecimal(20.05), "its a gnome", Category.GNOME, "clive.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(101, "Blue Gnome", new BigDecimal(300.99), "its a gnome", Category.GNOME, "gnome_swing.jpg", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(102, "Lumber Clive", new BigDecimal(908070.50), "its a gnome", Category.GNOME, "gnome2.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(103, "Doctor Clive", new BigDecimal(49.99), "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome3.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(104, "Wizard Clive", new BigDecimal(49.99), "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome1.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(105, "Doctor Clive", new BigDecimal(49.99), "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome3.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(106, "Wizard Clive", new BigDecimal(49.99), "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome1.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(107, "Lumber Clive", new BigDecimal(49.99), "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome2.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(108, "Doctor Clive", new BigDecimal(49.99), "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome3.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(109, "Clive Gnome", new BigDecimal(49.99), "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "clive.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));

		
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

	public List<Customer> getUsers() {
			return users;
	}
	public void addUser(Customer u) {
	 		users.add(u);
	}
	
}