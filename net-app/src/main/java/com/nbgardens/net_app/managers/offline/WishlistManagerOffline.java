package com.nbgardens.net_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.Wishlist;
import com.nbgardens.net_app.managers.WishlistManager;
import com.nbgardens.net_app.util.InitialData;

public class WishlistManagerOffline implements WishlistManager {
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistWishlist(Wishlist w){
		//initialData.addToWishlist(w);
	}
	
	@Override
	public void updateWishlist(Wishlist w){
		
	}
}
