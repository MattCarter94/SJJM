package com.qac.nbgardens.managers;

import com.qac.nbgardens.entities.WishlistProduct;

public interface WishlistProductManager {
	public void persistWishlistProduct(WishlistProduct wp);
	
	public void updateWishlistProduct();
	public void deleteWishlistProduct();

	public WishlistProduct getWishlistGivenUserEmail(String email);

	public void updateWishlist(String email, WishlistProduct wishlist);
	
}
