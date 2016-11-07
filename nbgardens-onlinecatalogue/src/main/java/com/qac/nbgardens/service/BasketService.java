package com.qac.nbgardens.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.CustomerOrderManager;
import com.qac.nbgardens.managers.ProductManager;
import com.qac.nbgardens.managers.UserManager;

@Stateless
public class BasketService {
	@Inject
	private CustomerOrderManager customerOrderManager;
	@Inject 
	private UserManager userManager;
	@Inject
	private ProductManager productManager;
	@Inject
	UserCredentials userCredentials;
	
	// Add a product to basket given a user id and product id
	public void addProduct(String email, Integer productID, int quantity) {
//		System.out.println("Adding product " + productID);
		CustomerOrder basket = customerOrderManager.getBasketGivenEmail(email); // basket is the local order associated with the current user
		
		if(basket == null) // if no such order exists
//			System.out.println("Basket is Null");
			basket = new CustomerOrder(userManager.getUserByEmail(email), OrderStatus.BASKET); // create the order, linking it to the user and specifying a status of basket
//		System.out.println("About to run addOrderLine");
		basket.addOrderLine(productManager.findProductById(productID), quantity); // this overrides one of these methods. adds a product to the logged in users]
		BigDecimal x = userCredentials.getTotal();
		userCredentials.setTotal(x.add(productManager.findProductById(productID).getPrice()));
//		System.out.println("The order line in the customer order has " + basket.getOrderLines().size() + " products in it");
//		System.out.println("End of addProduct...");
	}

	// Find the customer order that is linked to the customer id we provide, this order has status set to basket
	public CustomerOrder getUserBasket(String email) {// feed in id of user who's order we want to find
		CustomerOrder basket = customerOrderManager.getBasketGivenEmail(email); // basket is the order linked to the customer we specified
		if(basket == null) // if not such order exists, if the customer does not have an order with status of basket...
//			basket = new CustomerOrder(userManager.getUser(userID), OrderStatus.BASKET); // create a new customerOrder / basket, specifying the customer and that the order is technically a basket
			System.out.println("Basket is Null");
		return basket; // return the customer order / basket
	}

	public void deleteProduct(String email, Integer productID){
		CustomerOrder basket = customerOrderManager.getBasketGivenEmail(email);
		basket.deleteOrderLine(productID);
	}

	
}
