package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qac.nbgardens.entities.User;
import com.qac.nbgardens.entities.Wishlist;
import com.qac.nbgardens.managers.WishlistManager;
import com.qac.nbgardens.util.InitialData;

public class WishlistManagerOffline implements WishlistManager {
	@Inject
	private InitialData initialData;

	public void persistWishlist(Wishlist w) {
		// TODO Auto-generated method stub
		
	}

	public void updateWishlist(Wishlist w) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void persistWishlist(Wishlist w){
//		
//		List<User> u = initialData.getUsers();
//		for (int i = 0; i < u.size(); i++)
//		{
//			List<Wishlist> wish = new ArrayList<Wishlist>();
//			wish.add(u.get(i).getWishlist());
//			//generates list of wishlists, does nothing with it
//		}
//		
//		//initialData.addToWishlist(w);
//	}
//	
//	@Override
//	public void updateWishlist(Wishlist w){
//		List <User> u = initialData.getUsers();
//		for (int i = 0; i < u.size(); i++)
//		{
//			if (w.getWishlistID() == u.get(i).getWishlist().getWishlistID()) {
//				//Wishlist matched
//				u.get(i).setWishlist(w);
//				//TODO add this line but needs method in initialdata
//				//initialData.setUsers(u);
//			}
//		}
//	}
}
