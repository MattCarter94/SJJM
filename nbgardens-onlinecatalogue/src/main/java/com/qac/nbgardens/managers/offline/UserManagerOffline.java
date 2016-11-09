package com.qac.nbgardens.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Address;
import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.UserManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
public class UserManagerOffline implements UserManager{
	@Inject
	private InitialData initialData;
	
	
	public void createUser(CardDetails card, String firstName, String surname, String email, String phoneNo, String password, Address address) {
		Customer u = new Customer(card, firstName, surname, email, phoneNo, password, address);
		initialData.addUser(u);
	}
	
	
	
	public List<Customer> getUsers() {
		return initialData.getUsers();
	}
	

	@Override
	public Customer getUserByEmail(String email) {
		//Get all the users
		List<Customer> us = initialData.getUsers();
		//go through each one
		for(int i=0; i<us.size(); i++){
			//check to see if the emails match (not case sensitive)
			System.out.println(us.get(i).getEmail());
			if(us.get(i).getEmail().equals(email)){
				return us.get(i); //return the first one that matches
			}
		}
		return null; //return null if none found
			
		
		
		
		

	}



	@Override
	public void persistUser(CardDetails card, String name, String surname, String email, String phoneNo,
			String password, Integer permissions, String add1, String add2, String town, String county,
			String postcode) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void persistUsers(Customer c) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void removeCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}
	
}
