package com.qac.nbgardens.managers;

import com.qac.nbgardens.entities.Wishlist;

public interface WishlistManager {
	public void persistWishlist(Wishlist w);
	
	public void updateWishlist(Wishlist w);
	
}
