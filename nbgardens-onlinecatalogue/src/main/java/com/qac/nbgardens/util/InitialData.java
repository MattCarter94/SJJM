package com.qac.nbgardens.util;

import java.text.DecimalFormat;
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
import com.qac.nbgardens.entities.OrderLine;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.entities.enums.ProductStatus;



@Startup
@Singleton
public class InitialData {
	private ArrayList<Product> products = new ArrayList<Product>();
	//private List<Wishlist> wishlists = new ArrayList<Wishlist>();
	//private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
	
	private List<Customer> users = new ArrayList<Customer>();
	private List<CardDetails> cards = new ArrayList<CardDetails>();
	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
	private List<Address> addresses = new ArrayList<Address>();
	
	DecimalFormat df = new DecimalFormat("#.00"); 
	
	@PostConstruct
	public void SetupData() {
		
		//Add addresses
		addAddress(new Address("420", "Blaze Rd", "Cranberry", "Oxfordshire", "OX123AB"));
		
		
		//Add users
		addUser(new Customer(new CardDetails("123456789", "2018-05-03", "Matt"), "Matt", "Carter", "matt@email.co.uk", "02938475812", "password1", addresses.get(0)));
		addUser(new Customer(new CardDetails("123456789", "2018-05-03", "Dog"), "Dog", "Carter", "dog", "02938475812", "password1", addresses.get(0)));
		addUser(new Customer(new CardDetails("123456789", "2018-05-03", "Cat"), "Cat", "Carter", "cat@email.co.uk", "02938475812", "password1", addresses.get(0)));



		//Add products
		addProduct(new Product(100, "Glorious Clive", 20.00, "its a gnome", Category.GNOME, "clive.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(102, "Lumber Clive", 90, "its a gnome", Category.GNOME, "gnome2.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(103, "Doctor Clive", 49.99, "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome3.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(104, "Wizard Clive", 59.99, "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome1.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(105, "Doctor Clive", 69.99, "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome3.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(106, "Wizard Clive", 79.99, "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome1.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(101, "Swinging Gnomes", 300, "its a gnome", Category.GNOME, "gnome_swing.jpg", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(107, "Lumber Clive", 89.99, "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome2.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(108, "Doctor Clive", 29.99, "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "gnome3.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(109, "Clive Gnome", 49.99, "Place this awesome gnome in your garden and you too can praise the almight clive day and night!", Category.GNOME, "clive.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));

		addProduct(new Product(110, "Gnome Hat", 10, "A fancy hat", Category.GNOMEACCESSORY, "gnomeacc2.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(111, "Gnome Hat", 10, "A fancy hat", Category.GNOMEACCESSORY, "gnomeacc2.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(112, "Gnome Hat", 10, "A fancy hat", Category.GNOMEACCESSORY, "gnomeacc2.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		
		addProduct(new Product(113, "Garden Fountain", 69.99, "A fountain and stuff", Category.GARDENFOUNTIAN, "fountain1.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(114, "Garden Fountain", 69.99, "A fountain and stuff", Category.GARDENFOUNTIAN, "fountain1.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(115, "Garden Fountain", 69.99, "A fountain and stuff", Category.GARDENFOUNTIAN, "fountain1.png", "clive, lord, praise", 5000, ProductStatus.ACTIVE, new Date()));
		
		
		//Add Customer Order
		addCustomerOrder(new CustomerOrder(getCustomer(0), OrderStatus.BASKET));
		addCustomerOrder(new CustomerOrder(getCustomer(0), OrderStatus.INPROGRESS));
		
		addOrderLines(new OrderLine(customerOrders.get(1), products.get(0), 2));
		
		custOrderAddOrderLine(customerOrders.get(1), orderLines.get(0));
		
		//Add wishlists
		//addWishlist();
		
		//Add stockOrders
		//addStockOrder();
		
		//Add baskets
		//addBasket();
	}
	
	public void updateCustomerOrder(CustomerOrder basket, int idx){
		customerOrders.remove(idx);
		customerOrders.add(basket);
	}
	
	public void updateCheckoutOrder(CustomerOrder newBasket, int idx, CustomerOrder basket) {
		customerOrders.remove(idx);
		customerOrders.add(basket);
		customerOrders.add(newBasket);
	}
	
	public void custOrderAddOrderLine(CustomerOrder co, OrderLine ol){
		co.addOrderLine(ol);
	}
	
	public void addCustomerOrder(CustomerOrder cu) {
		customerOrders.add(cu);
	}
	
	public void addOrderLines(OrderLine ol){
		orderLines.add(ol);
	}
	
	public void addAddress(Address address){
		addresses.add(address);
	}
	
	

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public void setUsers(List<Customer> users) {
		this.users = users;
	}

	public Customer getCustomer(int index){
		return users.get(index);
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
	
	public ArrayList<Product> getProducts(double low, double high, Category category, String search) {
		ArrayList<Product> filtered = new ArrayList<Product>();
		
		if(search==""){
			if(category == Category.ALL){
				for(int i=0; i<=products.size()-1; i++){
					if(products.get(i).getPrice() >= low && products.get(i).getPrice() <= high){
						filtered.add(products.get(i));
					}
				}
			}
			
			else{
				for(int i=0; i<=products.size()-1; i++){
					if(products.get(i).getPrice() >= low && products.get(i).getPrice() <= high && products.get(i).getCategory() == category){
						filtered.add(products.get(i));
					}
				}
			}
		}
		
		if(search!=""){
			if(category == Category.ALL){
				for(int i=0; i<=products.size()-1; i++){
					if(products.get(i).getPrice() >= low && products.get(i).getPrice() <= high && products.get(i).getTitle().toLowerCase().contains(search.toLowerCase())){
						filtered.add(products.get(i));
					}
				}
			}
			
			else{
				for(int i=0; i<=products.size()-1; i++){
					if(products.get(i).getPrice() >= low && products.get(i).getPrice() <= high && products.get(i).getCategory() == category && products.get(i).getTitle().toLowerCase().contains(search.toLowerCase())){
						filtered.add(products.get(i));
					}
				}
			}
		}
		
		
		return filtered;
	}
	
	public ArrayList<Product> getProducts(String search) {
		ArrayList<Product> filtered = new ArrayList<Product>();
		
		for(int i=0; i<=products.size()-1; i++){
			if(products.get(i).getTitle().toLowerCase().contains(search.toLowerCase())){
				filtered.add(products.get(i));
			}
		}

		return filtered;
	}

	public List<Customer> getUsers() {
		return users;
	}
	
	public void addUser(Customer u) {
	 	users.add(u);
	}
	
	public String returnLastUser(){
		Integer userSize = users.size();
		return users.get(userSize - 1).getFirstName();
	}

	public List<CardDetails> getCards() {
		return cards;
	}

	public void setCards(List<CardDetails> cards) {
		this.cards = cards;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}