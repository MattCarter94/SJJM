package com.qac.nbgardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.service.WishlistService;
import com.qac.nbgardens.util.InitialData;

@Named("wishlist")
@RequestScoped //Only used when asked for
public class WishlistController {
	@Inject
	private WishlistService wishlistService;
	@Inject
	private UserCredentials userCredentials;
	@Inject
	private InitialData initialData;
	
	
	public void addToWishlist(Product product){
		wishlistService.addProduct(userCredentials.getUser().getEmail() , product.getProductID());
	}
	
}
