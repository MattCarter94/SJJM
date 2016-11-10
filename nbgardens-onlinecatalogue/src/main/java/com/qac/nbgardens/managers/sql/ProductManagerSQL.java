package com.qac.nbgardens.managers.sql;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.ValidationException;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.managers.PersistanceManager;
import com.qac.nbgardens.managers.ProductManager;

@Alternative
@Stateless
public class ProductManagerSQL implements ProductManager{
	@Inject
	private PersistanceManager pm;
	

	@Override
	public void persistProduct(Product p) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public void persistProducts(List<Product> p) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (Product product : p) {
			em.persist(product);
		}
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public Product findProductById(Integer id) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Product> tq = em.createNamedQuery("Product.FIND_PRODUCT_BY_ID", Product.class);
		pm.CloseEntityManager(em);
		//TODO: Replace with actual id table value
		tq.setParameter("ID", id);
		try {
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public ArrayList<Product> getProducts() {
		EntityManager em = pm.CreateEntityManager();
		ArrayList<Product> p = (ArrayList<Product>) em.createQuery("select * from products", Product.class).getResultList();
		pm.CloseEntityManager(em);
		return p;
	}

//	@Override
//	public void addProduct(Product p) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void updateProduct(Product p) {
		if (p == null) {
			throw new ValidationException("null");
		}
		EntityManager em = pm.CreateEntityManager();
		em.merge(p);
		pm.CloseEntityManager(em);
		
	}

	@Override
	public void removeProduct(Product p) {
		if (p == null) {
			throw new ValidationException("null");
		}
		
		EntityManager em = pm.CreateEntityManager();
		em.remove(p);
		pm.CloseEntityManager(em);
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> findAll(double low, double high, Category category, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> findAll(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}
