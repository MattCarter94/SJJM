package com.qac.nbgardens.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.service.WishlistService;

@Named("wishlist")
@RequestScoped //Only used when asked for
public class WishlistController {
	@Inject
	private WishlistService wishlistService;
	@Inject
	private UserCredentials userCredentials;
	
	
	private Integer deleteId;
	
	public void addToWishlist(Product product){
		wishlistService.addProduct(userCredentials.getUser().getEmail() , product.getProductID());
	}

	public Integer getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}
	
	public void removeFromWishlist(){
		System.out.println("wishlist remove " + deleteId);
		wishlistService.deleteProduct(userCredentials.getUser().getEmail(), deleteId);
	}
	
	public boolean containsItem(Integer productId){
		System.out.println(productId);
		boolean result = wishlistService.containsItem(userCredentials.getUser().getEmail(), productId);
		return result;
	}
	
}
