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
	private CustomerOrderManager basketManager;
	@Inject 
	private UserManager userManager;
	@Inject
	private ProductManager productManager;
	
	public void addProduct(Integer userID, Integer productID) {
		CustomerOrder basket = basketManager.getBasketGivenUser(userID);
		if(basket == null)
			basket = new CustomerOrder(userManager.getUser(userID), OrderStatus.BASKET);
		basket.addOrderLine(productManager.findProductById(productID), 1);
	}

	public CustomerOrder getUserBasket(Integer userID) {
		CustomerOrder basket = basketManager.getBasketGivenUser(userID);
		if(basket == null)
			basket = new CustomerOrder(userManager.getUser(userID), OrderStatus.BASKET);
		return basket;
	}

}
