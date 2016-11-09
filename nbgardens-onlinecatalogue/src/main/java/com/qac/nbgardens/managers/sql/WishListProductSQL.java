package com.qac.nbgardens.managers.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ValidationException;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.WishlistProduct;
import com.qac.nbgardens.managers.PersistanceManager;
import com.qac.nbgardens.managers.WishlistProductManager;

@Alternative
@Stateless
public class WishListProductSQL implements WishlistProductManager{

	@Inject
	private PersistanceManager pm;
	
	@Override
	public void persistWishlistProduct(WishlistProduct wp) {
		EntityManager em =  pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(wp);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public void updateWishlistProduct(WishlistProduct wp) {
		if (wp == null) throw new ValidationException("null");
		EntityManager em = pm.CreateEntityManager();
		em.merge(wp);
		pm.CloseEntityManager(em);		
	}

	@Override
	public void deleteWishlistProduct() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void deleteWishlistProduct(WishlistProduct wp) 
	{
		if (wp == null) throw new ValidationException("null");
		EntityManager em = pm.CreateEntityManager();
		em.remove(wp);
		pm.CloseEntityManager(em);
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

	@Override
	public void updateWishlistProduct() {
		// TODO Auto-generated method stub
		
	}

}
