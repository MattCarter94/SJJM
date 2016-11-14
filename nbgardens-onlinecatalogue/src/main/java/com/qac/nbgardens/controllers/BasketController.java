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

	
	private int quantity = 1;
	private Integer deleteId;


	// Attributes
	private CustomerOrder customerOrder = null; // Holds a single customer order
	
	// Methods
	public CustomerOrder getBasketProducts() {
		if(customerOrder == null) //If there is no customer order stored above
			customerOrder = basketService.getUserBasket(userCredentials.getUser().getEmail()); //set the customer order to what the service finds is linked to the user id we have in credentials when the user logged in
		return customerOrder; // return this order that is linked to the customer and is technically a basket
	}

	public void checkout(String email){
		basketService.checkout(email);
	}
	
	// Add a product to the order / basket
	public void addToBasket(Product product){ // specify a product
		if(userCredentials.isLoggedIn()) // if the customer using the website is logged in
			basketService.addProduct(userCredentials.getUser().getEmail() , product.getProductID(), quantity); // adding a product given the current users id and the products id
		    System.out.println("Adding " + product.getTitle());
	}
	
	public void removeFromBasket(){
		System.out.println("controller remove " + deleteId);
		basketService.deleteProduct(userCredentials.getUser().getEmail(), deleteId);
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
	
	public int basketQuantity(){
		return userCredentials.getBasket().getQuantity();
	}
	
}