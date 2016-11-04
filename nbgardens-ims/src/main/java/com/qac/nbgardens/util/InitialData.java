package com.qac.nbgardens.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.qac.nbgardens.entities.CustomerCard;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.entities.SupplierProducts;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.entities.enums.ProductStatus;

@Startup 
@Singleton
public class InitialData {
	private List<Product> products = new ArrayList<Product>();
	private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
<<<<<<< HEAD
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
=======
	private List<Customer> customers = new ArrayList<Customer>();	
>>>>>>> 2bebfc2967248c6171b083fba2515eb549744bb4
	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	@PostConstruct
	public void SetupData() {
		
		//Add users
		addCustomer(new Customer("jaredpepper@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "12 Clive Road", "Cliverton","Clivechester", "Clive Kingdom", "MER4 32D"), new Date()), "jaredpepper@gmail.com"), "Jared", "Pepper", "12345678998", "secret_password"));
		addCustomer(new Customer("joetrost@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "12 Clive Road", "Cliverton","Clivechester", "Clive Wales", "MER4 32D"), new Date()), "jaredpepper@gmail.com"), "Joe", "Trost", "12345678998", "secret_password"));
		addCustomer(new Customer("mattcarter@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "13 Clive Street", "Cliverton","Clivechester", "Clive England", "MER4 32E"), new Date()), "jaredpepper@gmail.com"), "Matt", "Carter", "12345678998", "secret_password"));
		addCustomer(new Customer("stefanmaslanka@gmail.com", new CustomerCard(new CardDetails("123123123", new Address(1, "14 Clive Lane", "Cliverton","Clivechester", "Clive Scotland", "MER4 32F"), new Date()), "jaredpepper@gmail.com"), "Stefan", "Maslanka", "12345678998", "secret_password"));
		//The email is added twice in text, I will come back to this later. In hind sight you would pass, through an 'email' variable, but this is just dummy data at the moment - Jared. 	
		
		//Add Products
		addProduct(new Product(100, "Green Gnome", new BigDecimal(9.99), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(101, "Blue Gnome", new BigDecimal(19.99), "its a gnome", Category.GARDENFOUNTIAN, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(102, "Rainbow Gnome", new BigDecimal(29.99), "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 5000, ProductStatus.ACTIVE, new Date()));
		addProduct(new Product(103, "Clive Gnome", new BigDecimal(39.99), "its a gnome", Category.GNOMEACCESSORY, "imgurl.png", "tag1, tag2, tag3", 200, ProductStatus.DISCONTINUED, new Date()));
		
		//Add Suppliers and supplier products and their prices to each supplier.
		addSupplier(new Supplier("Gnomes'R'Us"));
		suppliers.get(0).addSupplierProduct(new SupplierProducts(products.get(0), new BigDecimal(9.99),  new BigDecimal(7.99),  new BigDecimal(4.99)));
		suppliers.get(0).addSupplierProduct(new SupplierProducts(products.get(1), new BigDecimal(19.99),  new BigDecimal(15.99),  new BigDecimal(12.99)));
		suppliers.get(0).addSupplierProduct(new SupplierProducts(products.get(2), new BigDecimal(39.99),  new BigDecimal(32.99),  new BigDecimal(27.99)));
		
		addSupplier(new Supplier("We Gnome what you want"));
		suppliers.get(1).addSupplierProduct(new SupplierProducts(products.get(0), new BigDecimal(11.99),  new BigDecimal(9.99),  new BigDecimal(6.99)));
		suppliers.get(1).addSupplierProduct(new SupplierProducts(products.get(1), new BigDecimal(22.99),  new BigDecimal(17.99),  new BigDecimal(14.99)));
		suppliers.get(1).addSupplierProduct(new SupplierProducts(products.get(2), new BigDecimal(42.99),  new BigDecimal(34.99),  new BigDecimal(29.99)));
		
		addSupplier(new Supplier("Gnomes 4 lyf"));
		suppliers.get(2).addSupplierProduct(new SupplierProducts(products.get(0), new BigDecimal(8.99),  new BigDecimal(6.99),  new BigDecimal(3.99)));
		suppliers.get(2).addSupplierProduct(new SupplierProducts(products.get(1), new BigDecimal(18.99),  new BigDecimal(14.99),  new BigDecimal(11.99)));
		suppliers.get(2).addSupplierProduct(new SupplierProducts(products.get(2), new BigDecimal(38.99),  new BigDecimal(31.99),  new BigDecimal(26.99)));
		

		// Add Customer Orders
		try {
			customers.get(0).addCustomerOrder(new CustomerOrder(new OrderLine(products.get(0), 2, new BigDecimal(5.05)), customers.get(0).getCustEmail(), sdf.parse("31-08-2006"), OrderStatus.INPROGRESS));
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		try {
			customers.get(0).addCustomerOrder(new CustomerOrder(new OrderLine(products.get(2), 5, new BigDecimal(8.49)), customers.get(1).getCustEmail(), sdf.parse("08-02-2015"), OrderStatus.INPROGRESS));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			customers.get(2).addCustomerOrder(new CustomerOrder(new OrderLine(products.get(1), 5, new BigDecimal(9.99)), customers.get(2).getCustEmail(), sdf.parse("25-08-2016"), OrderStatus.INPROGRESS));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Add Stock Orders - Price will need to be calculated on a method, that takes into consideration supplier discount (100 orders etc).
		try {
			addStockOrder(new StockOrder(new StockLine(products.get(0), 5, new BigDecimal(19.99)), suppliers.get(0), sdf.parse("17-08-2016"), sdf.parse("21-08-2016")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			addStockOrder(new StockOrder(new StockLine(products.get(1), 7, new BigDecimal(39.99)), suppliers.get(1), sdf.parse("24-11-2016"), sdf.parse("29-11-2016")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void addStockOrder(StockOrder so) {
		stockOrders.add(so);
	}
	
	public void addCustomer(Customer c) {
		customers.add(c);
	}
	
	public void addSupplier(Supplier sup) {
		suppliers.add(sup);
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
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	

}