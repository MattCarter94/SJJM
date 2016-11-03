package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.CustomerManager;
import com.qac.nbgardens.util.InitialData;

@Stateless
@Default
public class CustomerManagerOffline implements CustomerManager{

	@Inject
	private InitialData initialData;
	
	@Override
	public void persistCustomer(Customer c) {
		initialData.addCustomer(c);
	}
	@Override
	public void persistCustomers(List<Customer> c) {
		for (Customer cu : c) {
			
			initialData.addCustomer(cu);
		}
	}
	
	@Override
	public Customer findCustomerById(Integer id) {
		List<Customer> customers = initialData.getCustomers();
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getEmail().equals(id)) {
				return customers.get(i);
			}
		}
		return null;
	}
	
	
	
	
	
	@Override
	public ArrayList<Customer> getCustomers() {

		return (ArrayList<Customer>) initialData.getCustomers();
	}
	@Override
	public void updateCustomer(Customer c) {
		List<Customer> customers = initialData.getCustomers();
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getEmail() == c.getEmail()) {
				customers.set(i, c);
			}
		}
	}
	@Override
	public void removeCustomer(Customer c) {
		//TODO left blank for now
	}
	@Override
	public List<Customer> findAll() {
		return initialData.getCustomers();
	}
	@Override
	public void persistCustomers(Customer c) {
		// TODO Auto-generated method stub
		
	}

}