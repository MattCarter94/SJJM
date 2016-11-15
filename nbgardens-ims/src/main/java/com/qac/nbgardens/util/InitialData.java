package com.qac.nbgardens.util;


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
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.entities.SupplierProduct;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.entities.enums.ProductStatus;

@Startup 
@Singleton
public class InitialData {
	private List<Product> products = new ArrayList<Product>();
	private List<StockOrder> stockOrders = new ArrayList<StockOrder>();
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	private List<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
//	private List<CardDetails> cards = new ArrayList<CardDetails>();
//	private List<OrderLine> orderLines = new ArrayList<OrderLine>();
//	private List<Address> addresses = new ArrayList<Address>();
	

	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
	@PostConstruct
	public void SetupData() {
		
		//Product
		Product p1 = new Product("Clive", 9.99d, "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 130000, ProductStatus.ACTIVE);
		Product p2 = new Product("Mega Clive", 19.99d, "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 1000, ProductStatus.ACTIVE);
		Product p3 = new Product("Happy Clive", 199.99d, "its a gnome", Category.GNOME, "imgurl.png", "tag1, tag2, tag3", 200, ProductStatus.ACTIVE);
		Product p4 = new Product("Clive Clive Hat Stand", 200.05d, "its a gnome", Category.GNOMEACCESSORY, "imgurl.png", "hatstand", 5, ProductStatus.ACTIVE);
		
		
		//Addresses
		Address a1 = new Address("12 Clive Road", "Cliverton","Clivechester", "Clive Kingdom", "MER4 32D");
		Address a2 = new Address("12 Clive Road", "Cliverton","Clivechester", "Clive Kingdom", "MER4 32D");
		Address a3 = new Address("12 Clive Road", "Cliverton","Clivechester", "Clive Kingdom", "MER4 32D");
		Address a4 = new Address("12 Clive Road", "Cliverton","Clivechester", "Clive Kingdom", "MER4 32D");
		

		//Card Details
		CardDetails cd1 = new CardDetails(),
					cd2 = new CardDetails(), 
					cd3 = new CardDetails(), 
					cd4 = new CardDetails();
		try {
			cd1 = new CardDetails("38948498192398", "Mr Clive", sdf.parse("31-08-2016"), a1);
			cd2 = new CardDetails("38973728281740", "Mr Superior Clive", sdf.parse("31-08-2006"), a2);
			cd3 = new CardDetails("17378283278178", "Mr Clive Almighty", sdf.parse("31-10-2010"), a3);
			cd4 = new CardDetails("98239198391829", "Mrs Clive", sdf.parse("31-08-2009"), a4);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Create customers
		Customer c1 = new Customer("clive@mail.com", "Clive", "MrMajestic", "09283748192", "password", a1);
		Customer c2 = new Customer("cliveman@mail.com", "Clive", "Almighty", "09283748192", "password", a2);
		Customer c3 = new Customer("clivelet@mail.com", "Clive", "The Divine", "09283748192", "password", a3);
		Customer c4 = new Customer("tomclive@mail.com", "Clive", "Clive", "09283748192", "password", a4);
		
		
//		//Create customer cards
//		CustomerCard cc1 = new CustomerCard(cd1.getCardNumber(), c1.getCustomerEmail(), cd1);
//		CustomerCard cc2 = new CustomerCard(cd2.getCardNumber(), c2.getCustomerEmail(), cd2);
//		CustomerCard cc3 = new CustomerCard(cd3.getCardNumber(), c3.getCustomerEmail(), cd3);
//		CustomerCard cc4 = new CustomerCard(cd4.getCardNumber(), c4.getCustomerEmail(), cd4);
		
		//Add cards to each customer
		c1.setCard(cd1);
		c2.setCard(cd2);
		c3.setCard(cd3);
		c4.setCard(cd4);
		
		//Add customer addresses
//		CustomerAddress ca1 = new CustomerAddress(a1.getAddressId(), c1.getCustomerEmail(), a1);
//		CustomerAddress ca2 = new CustomerAddress(a2.getAddressId(), c2.getCustomerEmail(), a2);
//		CustomerAddress ca3 = new CustomerAddress(a3.getAddressId(), c3.getCustomerEmail(), a3);
//		CustomerAddress ca4 = new CustomerAddress(a4.getAddressId(), c4.getCustomerEmail(), a4);
		
//		c1.addCustomerAddress(ca1);
//		c2.addCustomerAddress(ca2);
//		c3.addCustomerAddress(ca3);
//		c4.addCustomerAddress(ca4);
		
		//Add customer orders
		CustomerOrder co1 = new CustomerOrder(c1, new Date(), OrderStatus.INPROGRESS);
		CustomerOrder co2 = new CustomerOrder(c2, new Date(), OrderStatus.INPROGRESS);
		CustomerOrder co3 = new CustomerOrder(c3, new Date(), OrderStatus.INPROGRESS);
		CustomerOrder co4 = new CustomerOrder(c4, new Date(), OrderStatus.INPROGRESS);
		
		addCustomerOrder(co1);
		addCustomerOrder(co2);
		addCustomerOrder(co3);
		addCustomerOrder(co4);
		
		//Add order lines
		OrderLine ol1 = new OrderLine(co1, p1, 20);
		OrderLine ol2 = new OrderLine(co2, p2, 20);
		OrderLine ol3 = new OrderLine(co3, p3, 20);
		OrderLine ol4 = new OrderLine(co4, p4, 20);
				
		co1.addOrderLine(ol1);
		co2.addOrderLine(ol2);
		co3.addOrderLine(ol3);
		co4.addOrderLine(ol4);
		
		
		//Add suppliers
		Supplier s1 = new Supplier("Gnomes R Us");
		Supplier s2 = new Supplier("Go Hard Or Go Gnome");
		Supplier s3 = new Supplier("We Love Gnomes");

		
		//Add supplier products
		SupplierProduct sp1 = new SupplierProduct(s1, p1, 10d, 80d, 700d);
		SupplierProduct sp2 = new SupplierProduct(s1, p2, 20d, 90d, 800d);
		SupplierProduct sp3 = new SupplierProduct(s2, p3, 30d, 100d, 900d);
		SupplierProduct sp4 = new SupplierProduct(s3, p4, 40d, 110d, 1000d);
		
		
		s1.addSupplierProducts(sp1);
		s1.addSupplierProducts(sp2);
		s2.addSupplierProducts(sp3);
		s3.addSupplierProducts(sp4);
		
		
		//Add stock orders
		StockOrder 	so1 = new StockOrder(),
					so2 = new StockOrder(),  
					so3 = new StockOrder();			                               
		try
		{	
			 so1 = new StockOrder(s1, sdf.parse("05-9-2016"), sdf.parse("03-11-2016"), true);
			 so2 = new StockOrder(s2, sdf.parse("10-10-2016"),sdf.parse("05-11-2016"), true);
			 so3 = new StockOrder(s3, sdf.parse("03-11-2016"), null, false);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
		addStockOrder(so1);
		addStockOrder(so1);
		addStockOrder(so1);
	
		
		//Add stocklines for stock orders
		StockLine sl1 = new StockLine(so1, p1, 50);
		StockLine sl2 = new StockLine(so1, p2, 100);
		StockLine sl3 = new StockLine(so2, p2, 150);
		StockLine sl4 = new StockLine(so2, p3, 200);
		StockLine sl5 = new StockLine(so3, p4, 350);
		
		so1.addStockLine(sl1);
		so1.addStockLine(sl2);
		so1.addStockLine(sl2);
		so2.addStockLine(sl3);
		so3.addStockLine(sl4);
		so3.addStockLine(sl5);
		
		
		s1.addStockOrder(so1);
		s2.addStockOrder(so2);
		s3.addStockOrder(so3);	
		
		
		
		//Adding elements
		//Add Customers
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		
		//Add Products
		products.add(p1);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		//Add Suppliers
		suppliers.add(s1);
		suppliers.add(s2);
		suppliers.add(s3);
		


	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	//public void addStockOrder(StockOrder so) {
	//	stockOrders.add(so);
	//}
	
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

	//public List<StockOrder> getStockOrders() {
	//	return stockOrders;
	//}
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	
	public void addStockOrder(StockOrder so){
		stockOrders.add(so);
	}
	
	public List<StockOrder> getStockOrders(){
		return stockOrders;
	}
	
	public void addCustomerOrder(CustomerOrder co){
		customerOrders.add(co);
	}
	
	public List<CustomerOrder> getCustomerOrders(){
		return customerOrders;
	}

	public void updateStockOrder(StockOrder so) {
		for(int i=0; i<stockOrders.size(); i++){
			if(stockOrders.get(i).getStockOrderId() == so.getStockOrderId()){
				stockOrders.remove(i);
				stockOrders.add(so);
			}
		}
		
	}

}