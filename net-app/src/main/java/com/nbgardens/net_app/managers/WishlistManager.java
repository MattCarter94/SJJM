package com.nbgardens.net_app.managers;

import com.nbgardens.net_app.entities.Wishlist;

public interface WishlistManager {
	public void persistWishlist(Wishlist w);
	
	public void updateWishlist(Wishlist w);
	
}
