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

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.CustomerManager;
import com.qac.nbgardens.managers.PersistanceManager;

@Alternative
@Stateless
public class CustomerManagerSQL implements CustomerManager
{
	
	@Inject
	private PersistanceManager pm;
	
	@Override
	public void persistCustomers(Customer c) 
	{
		EntityManager em =  pm.CreateEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	@Override
	public void persistCustomers(List<Customer> c) 
	{
		EntityManager em = pm.CreateEntityManager();
		em.getTransaction().begin();
		for (Customer cu : c)
		{
			em.persist(c);
		}
			
		em.getTransaction().commit();
		pm.CloseEntityManager(em);
	}

	
	@Override
	public Customer findCustomerById(Integer id) 
	{
		EntityManager em = pm.CreateEntityManager();
		TypedQuery<Customer> tq = em.createNamedQuery("Customer.findCustomerByEmail", Customer.class);
		pm.CloseEntityManager(em);
		tq.setParameter("Email", id);
		try
		{
			return tq.getSingleResult();
		} 
		catch (NoResultException nre) 
		{
			return null;
		}
	
	}

	@Override
	public ArrayList<Customer> getCustomers() 
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

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persistCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	
}

