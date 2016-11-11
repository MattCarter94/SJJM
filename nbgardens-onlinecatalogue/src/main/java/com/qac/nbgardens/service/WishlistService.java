package com.qac.nbgardens.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.WishlistProduct;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.ProductManager;
import com.qac.nbgardens.managers.UserManager;
import com.qac.nbgardens.managers.WishlistProductManager;

@Stateless
public class WishlistService {
	@Inject
	private ProductManager productManager;
	@Inject
	UserCredentials userCredentials;
	@Inject
	WishlistProductManager wishlistProductManager;
	@Inject 
	private UserManager userManager;
	
	
	public void addProduct(String email, Integer productID) {
//		WishlistProduct wishlist = userCredentials.getUser().getWishlist();
//		wishlist.addProduct(productManager.findProductById(productID));
		
		Customer customer = userManager.getUserByEmail(email);
		customer.getWishlistProduct().addProduct(productManager.findProductById(productID));
	}


	public void deleteProduct(String email, Integer deleteId) {
		WishlistProduct wishlist = userCredentials.getUser().getWishlistProduct();
		
		for(int i=0; i<=wishlist.getProducts().size()-1; i++){
			if(wishlist.getProducts().get(i).getProductID() == deleteId){
				wishlist.getProducts().remove(i);
			}
		}
		wishlistProductManager.updateWishlist(email, wishlist);
	}


	public boolean containsItem(String email, Integer productId) {
		boolean x = false;
		List<Product> wishlist = userManager.getUserByEmail(email).getWishlistProduct().getProducts();
		for(int i=0; i<=wishlist.size()-1; i++){
			if(wishlist.get(i).getProductID().equals(productId)){
				x = true;
				return x;
			}
		}
		return x;
	}
	
}
