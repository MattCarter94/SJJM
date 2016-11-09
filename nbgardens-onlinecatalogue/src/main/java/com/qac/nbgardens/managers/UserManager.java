package com.qac.nbgardens.managers;

import java.util.List;

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;

public interface UserManager {
	public void persistUser(CardDetails card, String name, String surname, String email, String phoneNo, String password, Integer permissions, String add1, String add2, String town, String county, String postcode);
	

	public Customer getUserByEmail(String email);
	public List<Customer> getUsers();


	void persistUsers(Customer c);


	void updateCustomer(Customer c);


	void removeCustomer(Customer c);
	
}
