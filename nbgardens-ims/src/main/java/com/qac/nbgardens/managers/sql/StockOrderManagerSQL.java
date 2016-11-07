package com.qac.nbgardens.managers.sql;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.qac.nbgardens.entities.StockOrder;
import com.qac.nbgardens.managers.PersistanceManager;
import com.qac.nbgardens.managers.StockOrderManager;

@Alternative
@Stateless
public class StockOrderManagerSQL implements StockOrderManager{

	@Inject
	private PersistanceManager pm;
	
	@Override
	public Date getStockOrderDate(Integer stockOrderID) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(stockOrderID);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return null;
	}

	@Override
	public Date getstockRecievedDate(Integer stockOrderID) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(stockOrderID);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return null;
	}

	@Override
	public List<StockOrder> findAll() {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(em);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return null;
	}

}
