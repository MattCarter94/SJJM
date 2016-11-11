package com.qac.nbgardens.util;


import java.math.BigDecimal;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.mysql.jdbc.DatabaseMetaDataUsingInfoSchema;
import com.qac.nbgardens.entities.Address;
import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerAddress;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.OrderLine;
import com.qac.nbgardens.entities.CustomerCard;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.StockLine;
import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.entities.Supplier;
import com.qac.nbgardens.entities.SupplierProduct;
import com.qac.nbgardens.entities.WishlistProduct;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.entities.enums.ProductStatus;

@Startup 
@Singleton
public class InitialData {
	private List<Product> products = new ArrayList<Product>();
	//private List<StockOrder> stockOrders = new ArrayList<StockOrder>();

	private List<Customer> customers = new ArrayList<Customer>();
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	

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
			cd1 = new CardDetails("38948498192398", a1.getAddressId(), "Mr Clive", sdf.parse("31-08-2016"), a1);
			cd2 = new CardDetails("38973728281740", a2.getAddressId(), "Mr Superior Clive", sdf.parse("31-08-2006"), a2);
			cd3 = new CardDetails("17378283278178", a3.getAddressId(), "Mr Clive Almighty", sdf.parse("31-10-2010"), a3);
			cd4 = new CardDetails("98239198391829", a4.getAddressId(), "Mrs Clive", sdf.parse("31-08-2009"), a4);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Create customers
		Customer c1 = new Customer("clive@mail.com", "Clive", "MrMajestic", "09283748192", "password");
		Customer c2 = new Customer("cliveman@mail.com", "Clive", "Almighty", "09283748192", "password");
		Customer c3 = new Customer("clivelet@mail.com", "Clive", "The Divine", "09283748192", "password");
		Customer c4 = new Customer("tomclive@mail.com", "Clive", "Clive", "09283748192", "password");
		
		
		//Create customer cards
		CustomerCard cc1 = new CustomerCard(cd1.getCardNumber(), c1.getCustomerEmail(), cd1);
		CustomerCard cc2 = new CustomerCard(cd2.getCardNumber(), c2.getCustomerEmail(), cd2);
		CustomerCard cc3 = new CustomerCard(cd3.getCardNumber(), c3.getCustomerEmail(), cd3);
		CustomerCard cc4 = new CustomerCard(cd4.getCardNumber(), c4.getCustomerEmail(), cd4);
		
		//Add cards to each customer
		c1.addCustomerCard(cc1);
		c2.addCustomerCard(cc2);
		c3.addCustomerCard(cc3);
		c4.addCustomerCard(cc4);
		
		//Add customer addresses
		CustomerAddress ca1 = new CustomerAddress(a1.getAddressId(), c1.getCustomerEmail(), a1);
		CustomerAddress ca2 = new CustomerAddress(a2.getAddressId(), c2.getCustomerEmail(), a2);
		CustomerAddress ca3 = new CustomerAddress(a3.getAddressId(), c3.getCustomerEmail(), a3);
		CustomerAddress ca4 = new CustomerAddress(a4.getAddressId(), c4.getCustomerEmail(), a4);
		
		c1.addCustomerAddress(ca1);
		c2.addCustomerAddress(ca2);
		c3.addCustomerAddress(ca3);
		c4.addCustomerAddress(ca4);
		
		//Add customer orders
		CustomerOrder co1 = new CustomerOrder(c1.getCustomerEmail(), c1.getCustomerAddresses().get(0).getAddressId(), new Date(), OrderStatus.INPROGRESS, a1);
		CustomerOrder co2 = new CustomerOrder(c2.getCustomerEmail(), c2.getCustomerAddresses().get(0).getAddressId(), new Date(), OrderStatus.INPROGRESS, a2);
		CustomerOrder co3 = new CustomerOrder(c3.getCustomerEmail(), c3.getCustomerAddresses().get(0).getAddressId(), new Date(), OrderStatus.INPROGRESS, a3);
		CustomerOrder co4 = new CustomerOrder(c4.getCustomerEmail(), c4.getCustomerAddresses().get(0).getAddressId(), new Date(), OrderStatus.INPROGRESS, a4);
		
		//Add order lines
		OrderLine ol1 = new OrderLine(co1.getCustomerOrderId(), p1.getProductId(), 20, p1);
		OrderLine ol2 = new OrderLine(co2.getCustomerOrderId(), p2.getProductId(), 20, p2);
		OrderLine ol3 = new OrderLine(co3.getCustomerOrderId(), p3.getProductId(), 20, p3);
		OrderLine ol4 = new OrderLine(co4.getCustomerOrderId(), p4.getProductId(), 20, p4);
				
		co1.addOrderLine(ol1);
		co2.addOrderLine(ol2);
		co3.addOrderLine(ol3);
		co4.addOrderLine(ol4);
		
		
		//Add suppliers
		Supplier s1 = new Supplier("Gnomes R Us");
		Supplier s2 = new Supplier("Go Hard Or Go Gnome");
		Supplier s3 = new Supplier("We Love Gnomes");

		
		//Add supplier products
		SupplierProduct sp1 = new SupplierProduct(s1.getSupplierId(), p1.getProductId(), 10d, 80d, 700d, p1);
		SupplierProduct sp2 = new SupplierProduct(s1.getSupplierId(), p2.getProductId(), 20d, 90d, 800d, p2);
		SupplierProduct sp3 = new SupplierProduct(s2.getSupplierId(), p3.getProductId(), 30d, 100d, 900d, p3);
		SupplierProduct sp4 = new SupplierProduct(s3.getSupplierId(), p4.getProductId(), 40d, 110d, 1000d, p4);
		
		
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
			 so1 = new StockOrder(s1.getSupplierId(), sdf.parse("05-9-2016"), sdf.parse("03-11-2016"), true);
			 so2 = new StockOrder(s2.getSupplierId(), sdf.parse("10-10-2016"),sdf.parse("05-11-2016"), true);
			 so3 = new StockOrder(s3.getSupplierId(), null, null, false);
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		
	
		
		//Add stocklines for stock orders
		StockLine sl1 = new StockLine(so1.getStockOrderId(), p1.getProductId(), 50, p1);
		StockLine sl2 = new StockLine(so1.getStockOrderId(), p2.getProductId(), 100, p2);
		StockLine sl3 = new StockLine(so2.getStockOrderId(), p2.getProductId(), 150, p2);
		StockLine sl4 = new StockLine(so2.getStockOrderId(), p3.getProductId(), 200, p3);
		StockLine sl5 = new StockLine(so3.getStockOrderId(), p4.getProductId(), 350, p4);
		
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
	

}