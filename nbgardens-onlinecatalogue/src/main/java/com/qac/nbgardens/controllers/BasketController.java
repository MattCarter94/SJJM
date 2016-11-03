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
	private CustomerOrder customerOrder = null; // Holds a single customer order
	
	// Methods
	public CustomerOrder getBasketProducts() {
		if(customerOrder == null) //If there is no customer order stored above
			customerOrder = basketService.getUserBasket(userCredentials.getUser().getUserID()); //set the customer order to what the service finds is linked to the user id we have in credentials when the user logged in
		return customerOrder; // return this order that is linked to the customer and is technically a basket
	}

	// Set customer order above to one we specify
	public void setBasketProducts(CustomerOrder basketProducts) {
		this.customerOrder = basketProducts;
	}
	
	// Add a product to the order / basket
	public void addToBasket(int productId){ // specify a product
		System.out.println("Entered the method...");
		if(userCredentials.isLoggedIn()) // if the customer using the website is logged in
			basketService.addProduct(userCredentials.getUser().getUserID(), productId); // adding a product given the current users id and the products id
		    System.out.println("Actually added something");
	}
	
	public void removeFromBasket(Integer id){
		for (int i=0; i>customerOrder.getOrderLines().size(); i++){
			if(customerOrder.getOrderLines().get(i).getProduct().getProductID() == id){
				customerOrder.getOrderLines().remove(i);
			}
		}
	}
}