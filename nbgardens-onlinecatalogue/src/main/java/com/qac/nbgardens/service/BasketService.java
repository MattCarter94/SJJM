package com.qac.nbgardens.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
	
	// Add a product to basket given a user id and product id
	public void addProduct(Integer userID, Integer productID) {
		System.out.println("Adding product " + productID);
		CustomerOrder basket = customerOrderManager.getBasketGivenUser(userID); // basket is the local order associated with the current user
		if(basket == null) // if no such order exists
			basket = new CustomerOrder(userManager.getUser(userID), OrderStatus.BASKET); // create the order, linking it to the user and specifying a status of basket
		basket.addOrderLine(productManager.findProductById(productID), 1); // this overrides one of these methods. adds a product to the logged in users]
	}

	// Find the customer order that is linked to the customer id we provide, this order has status set to basket
	public CustomerOrder getUserBasket(Integer userID) {// feed in id of user who's order we want to find
		CustomerOrder basket = customerOrderManager.getBasketGivenUser(userID); // basket is the order linked to the customer we specified
		if(basket == null) // if not such order exists, if the customer does not have an order with status of basket...
			basket = new CustomerOrder(userManager.getUser(userID), OrderStatus.BASKET); // create a new customerOrder / basket, specifying the customer and that the order is technically a basket
		return basket; // return the customer order / basket
	}

}
