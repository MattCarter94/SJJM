package com.qac.nbgardens.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.CustomerOrderManager;
import com.qac.nbgardens.service.BasketService;
import com.qac.nbgardens.util.InitialData;

@Named("basketController")
@RequestScoped //Only used when asked for
public class BasketController {
	@Inject
	private BasketService basketService;
	@Inject
	private UserCredentials userCredentials;
	@Inject
	private InitialData initialData;
//	@Inject
//	private CustomerOrderManager customerOrderManager;
	
	private int quantity;
	private Integer deleteId;

	// Attributes
	private CustomerOrder customerOrder = null; // Holds a single customer order
	
	// Methods
	public CustomerOrder getBasketProducts() {
		if(customerOrder == null) //If there is no customer order stored above
			customerOrder = basketService.getUserBasket(userCredentials.getUser().getEmail()); //set the customer order to what the service finds is linked to the user id we have in credentials when the user logged in
		return customerOrder; // return this order that is linked to the customer and is technically a basket
	}

	// Set customer order above to one we specify
//	public void setBasket(String email) {
//		if(customerOrder == null){
//			List<CustomerOrder> customerOrders = new ArrayList<>(); // Create empty list to contain customer orders
//			initialData.getCustomerOrders().forEach(co->{ // Get list of customer orders. For each order in this list...
//				if(co.getCustomer().getEmail().equals(email) && co.getStatus().equals(OrderStatus.BASKET)){ // If the order has a customer who's id is equal to the one we feed in, and the orders status is set to basket...
//					customerOrders.add(co); // Add the order we found to the local list created above
//					this.customerOrder = customerOrders.get(0);
//					userCredentials.basket = customerOrders.get(0);
//				}
//			});
//			if(customerOrders.size() == 0){
//				//TODO Create new order linked to customer
//			}
//		}
//		
//	}
	
	// Add a product to the order / basket
	public void addToBasket(Product product){ // specify a product
//		System.out.println("Entered the method...");
		if(userCredentials.isLoggedIn()) // if the customer using the website is logged in
			basketService.addProduct(userCredentials.getUser().getEmail() , product.getProductID(), quantity); // adding a product given the current users id and the products id
		    System.out.println("Adding " + product.getTitle());
//		    System.out.println("user id is " + userCredentials.getUser().getEmail() + " and product id is " + product.getProductID());
//		    System.out.println("User orderlines " + userCredentials.getBasket().getOrderLines().size());
//		    System.out.println("CO orderlines " + customerOrderManager.getBasketGivenEmail(userCredentials.getUser().getEmail()).getOrderLines().size());
	}
	
	public void removeFromBasket(){
//		System.out.println(deleteId);
		Integer productID = userCredentials.getDeleteId();
		basketService.deleteProduct(userCredentials.getUser().getEmail(), productID);
//		System.out.println("Deleted product" + deleteId);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity==0){
			quantity=1;
		}
		this.quantity = quantity;
	}

	public Integer getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}
	
}