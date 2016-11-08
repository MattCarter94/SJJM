package com.qac.nbgardens.managers.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.nbgardens.entities.WishlistProduct;
import com.qac.nbgardens.managers.WishlistProductManager;

@Alternative
@Stateless
public class WishListProductSQL implements WishlistProductManager{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWishlist(String email, WishlistProduct wishlist) {
		// TODO Auto-generated method stub
		
	}

}
