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

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.PersistanceManager;
import com.qac.nbgardens.managers.UserManager;

@Alternative
@Stateless
public class UserManagerSQL implements UserManager {

	@Inject
	private PersistanceManager pm;
	
	@Override
	public void persistUser(CardDetails card, String name, String surname, String email, String phoneNo,
			String password, Integer permissions, String add1, String add2, String town, String county,
			String postcode) {
	}

	@Override
	public void persistUsers(Customer c) 
	{
		EntityManager em =  pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public Customer getUserByEmail(String email) {
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery("Customer.findCustomerByEmail", Customer.class);
		pm.CloseEntityManager(em);
		tq.setParameter("Email", email);
		try{
			return tq.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public ArrayList<Customer> getUsers() 
	{
		EntityManager em =pm.CreateEntityManager();
		ArrayList<Customer> customer = (ArrayList<Customer>) em.createQuery("Select * From customers", Customer.class).getResultList();
		pm.CloseEntityManager(em);
		return customer;
	}

	@Override
	public void updateCustomer(Customer c) 
	{
		if (c == null) throw new ValidationException("null");
		EntityManager em = pm.CreateEntityManager();
		em.merge(c);
		pm.CloseEntityManager(em);
	}

	@Override
	public void removeCustomer(Customer c) 
	{
		if (c == null) throw new ValidationException("null");
		EntityManager em = pm.CreateEntityManager();
		em.remove(c);
		pm.CloseEntityManager(em);
	}
	
}
