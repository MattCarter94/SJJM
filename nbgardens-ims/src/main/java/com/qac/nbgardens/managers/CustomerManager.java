
package com.qac.nbgardens.managers;

import java.util.ArrayList;
import java.util.List;

import com.qac.nbgardens.entities.Customer;
public interface CustomerManager {
	
	
	public void persistCustomers(Customer c);
	public void persistCustomers(List<Customer> c);
	
	public Customer findCustomerById(Integer id);
	public ArrayList<Customer> getCustomers();
	
	public void updateCustomer (Customer c);
	public void removeCustomer (Customer c);
	public List<Customer> findAll();
	public void persistCustomer(Customer c);
}


