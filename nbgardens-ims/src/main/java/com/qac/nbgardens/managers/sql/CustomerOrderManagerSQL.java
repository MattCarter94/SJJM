package com.qac.nbgardens.managers.sql;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.CustomerOrderManager;
import com.qac.nbgardens.managers.PersistanceManager;

@Alternative
@Stateless
public class CustomerOrderManagerSQL implements CustomerOrderManager{

	@Inject
	private PersistanceManager pm;
	
	@Override
	public Date returnOrderDate(Integer customerOrderID) {
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(customerOrderID);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
		
		return null;
	}

//	@Override
//	public OrderStatus findOrderStatus(Integer customerOrderID) {
//		EntityManager em = pm.CreateEntityManager();
//		TypedQuery<CustomerOrder> tq = em.createNamedQuery("CustomerOrder.findOrderStatus", CustomerOrder.class);
//		pm.CloseEntityManager(em);
//		tq.setParameter("customerOrder", customerOrder);
//		try{
//			return tq.getSingleResult();
//			} catch(NoResultException nre) {
//				return null;
//		
//	}

	@Override
	public List<CustomerOrder> findAll() {
		EntityManager em = pm.CreateEntityManager();
		List<CustomerOrder> orders = em.createQuery("select * from CustomerOrders", CustomerOrder.class).getResultList();
		pm.CloseEntityManager(em);
		return orders;
	}

	@Override
	public OrderStatus findOrderStatus(Integer customerOrderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
