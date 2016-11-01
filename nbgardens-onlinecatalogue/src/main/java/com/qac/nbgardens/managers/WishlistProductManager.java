package com.qac.nbgardens.managers;

import com.qac.nbgardens.entities.WishlistProduct;

public interface WishlistProductManager {
	public void persistWishlistProduct(WishlistProduct wp);
	
	public void updateWishlistProduct();
	public void deleteWishlistProduct();
}
