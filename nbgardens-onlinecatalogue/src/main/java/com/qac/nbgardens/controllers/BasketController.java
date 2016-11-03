package com.qac.nbgardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.service.BasketService;

@Named("basketController")
@RequestScoped //Only used when asked for
public class BasketController {
	@Inject
	private BasketService basketService;
	@Inject
	private UserCredentials userCredentials;

	// Attributes
	private CustomerOrder basketProducts = null;
	
	// Getters and Setters
	public CustomerOrder getBasketProducts() {
		if(basketProducts == null)
			basketProducts = basketService.getUserBasket(userCredentials.getUser().getUserID());
		return basketProducts;
	}

	public void setBasketProducts(CustomerOrder basketProducts) {
		this.basketProducts = basketProducts;
	}
	
	public void addToBasket(Product p){
		if(userCredentials.isLoggedIn())
			basketService.addProduct(userCredentials.getUser().getUserID(), p.getProductID());
	}
	
	public void removeFromBasket(Integer id){
		for (int i=0; i>basketProducts.getOrderLines().size(); i++){
			if(basketProducts.getOrderLines().get(i).getProduct().getProductID() == id){
				basketProducts.getOrderLines().remove(i);
			}
		}
	}
}