package com.qac.nbgardens.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.entities.enums.ProductStatus;
import com.qac.nbgardens.managers.CustomerManager;
import com.qac.nbgardens.managers.offline.CustomerManagerOffline;



@Startup
@Singleton
public class InitialData {
	private List<Product> products = new ArrayList<Product>();
	//private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	//private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<Customer> customers = new ArrayList<Customer>();
	
	@PostConstruct
	public void SetupData() {
		//Add users
		addCustomer(new Customer("Jared", "Pepper","jaredpepper@gmail.com", "12345678998", "secret_password", 1, "12 Manc Hill", "Manchester", "Manchester City", "Greater Manchester", "MANC H3S"));
		addCustomer(new Customer("Joe", "Trost","joetrost@gmail.com", "12345678998", "secret_password", 1, "12 Manc Hill", "Manchester", "Manchester City", "Greater Manchester", "MANC H3S"));
		addCustomer(new Customer("Matt", "Carter","mattcarter@gmail.com", "12345678998", "secret_password", 1, "12 Manc Hill", "Manchester", "Manchester City", "Greater Manchester", "MANC H3S"));
		addCustomer(new Customer("Stefan", "Maslanka","stefanaslanka@gmail.com", "12345678998", "secret_password", 1, "12 Manc Hill", "Manchester", "Manchester City", "Greater Manchester", "MANC H3S"));

		//Add products
		addProduct(new Product(100, "Green Gnome", new BigDecimal(20.05), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(101, "Blue Gnome", new BigDecimal(300.99), "its a gnome", Category.GARDENFOUNTIAN, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(102, "Rainbow Gnome", new BigDecimal(908070.50), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));


		// Add Customer Orders
	//	customers.get(1).ad
	//	customers.get(1).addCustomerOrder(new Basket(), new Date(), OrderStatus.INPROGRESS);
		
		//addCustomerOrder(new CustomerOrder(CustomerManagerOffline.this.findCustomerById(1), orderDate, status));
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
	
	public void addCustomer(Customer c) {
		customers.add(c);
	}
	
	public void addCustomerOrder(CustomerOrder co) {
		customerOrders.add(co);
	}
	

	public List<CustomerOrder> getCustomerOrders() {
		return customerOrders;
	}
	
	public List<Customer> getCustomers() {
		return (ArrayList<Customer>) customers;
	}

	public ArrayList<Product> getProducts() {
		
		return (ArrayList<Product>) products;
	}

	public List<StockOrder> getStockOrders() {
		return stockOrders;
	}
	
}