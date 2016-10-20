package com.nbgardens.net_app.managers;

import com.nbgardens.net_app.entities.WishlistProduct;

public interface WishlistProductManager {
	public void persistWishlistProduct(WishlistProduct wp);
	
	public void updateWishlistProduct();
	public void deleteWishlistProduct();
}
