package com.qac.nbgardens.managers.offline;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.WishlistProduct;
import com.qac.nbgardens.managers.UserManager;
import com.qac.nbgardens.managers.WishlistProductManager;

@Default
@Stateless
public class WishlistProductManagerOffline implements WishlistProductManager{
	
	@Inject
	UserManager userManager;
	
	@Override
	public void persistWishlistProduct(WishlistProduct wp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateWishlistProduct() {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteWishlistProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WishlistProduct getWishlistGivenUserEmail(String email) {
		return null;
	}
	@Override
	public void updateWishlist(String email, WishlistProduct wishlist) {
		userManager.getUserByEmail(email).setWishlistProduct(wishlist);
	}
	@Override
	public void updateWishlistProduct(WishlistProduct wp) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteWishlistProduct(WishlistProduct wp) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void persistWishlistProduct(WishlistProduct wp){
//		
//	}
//	@Override
//	public void updateWishlistProduct() {
//		
//		
//	}
//	@Override
//	public void deleteWishlistProduct() {
//		
//		
//	}
}
