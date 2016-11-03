package com.qac.nbgardens.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.qac.nbgardens.entities.Address;
import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.CustomerCard;
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
	private List<Customer> customers = new ArrayList<Customer>();
	
	@PostConstruct
	public void SetupData() {
		//Add users
		addCustomer(new Customer("jaredpepper@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "12 Clive Road", "Cliverton","Clivechester", "Clive Kingdom", "MER4 32D"), new Date()), "jaredpepper@gmail.com"), "Jared", "Pepper", "12345678998", "secret_password"));
		addCustomer(new Customer("joetrost@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "12 Clive Road", "Cliverton","Clivechester", "Clive Wales", "MER4 32D"), new Date()), "jaredpepper@gmail.com"), "Joe", "Trost", "12345678998", "secret_password"));
		addCustomer(new Customer("mattcarter@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "13 Clive Street", "Cliverton","Clivechester", "Clive England", "MER4 32E"), new Date()), "jaredpepper@gmail.com"), "Matt", "Carter", "12345678998", "secret_password"));
		addCustomer(new Customer("stefanmaslanka@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "14 Clive Lane", "Cliverton","Clivechester", "Clive Scotland", "MER4 32F"), new Date()), "jaredpepper@gmail.com"), "Stefan", "Maslanka", "12345678998", "secret_password"));
		//The email is added twice in text, I will come back to this later. In hind sight you would pass, through an 'email' variable, but this is just dummy data at the moment - Jared. 	
		
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
		//addStockOrder();s
		
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