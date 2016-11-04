package com.qac.nbgardens.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.Wishlist;
import com.qac.nbgardens.managers.UserManager;
import com.qac.nbgardens.util.InitialData;

@Default
@Stateless
public class UserManagerOffline implements UserManager{
	@Inject
	private InitialData initialData;
	
	
	public void persistUser(CardDetails card, Wishlist wishlist, String firstName, String surname, String email, String phoneNo, String password, Integer permissions, String houseNo, String street, String town, String county, String postcode) {
		Customer u = new Customer(card, firstName, surname, email, phoneNo, password,  houseNo, street, town, county, postcode);
		initialData.addUser(u);
	}
	
	

	public Customer getUser(Integer id) {
		List<Customer> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(id)){
				return us.get(i);
			}
		}
		return null;
		
	}
	
	public List<Customer> getUsers() {
		return initialData.getUsers();
	}
	
	
	
	public void updateUserEmail(Integer id, String email) {
		int count = 0;
		List<Customer> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(id)){
				us.get(i).setEmail(email);
				count++;
			}
		}
		if(count==0){
			System.out.println("No user with that ID found");
		}
		
	}
	
	//@Override
	public void updateUserPhoneNo(Integer id, String phoneNo) {
		int count = 0;
		List<Customer> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(id)){
				us.get(i).setPhoneNumber(phoneNo);
				count++;
			}
		}
		if(count==0){
			System.out.println("No user with that ID found");
		}
		
	}
	
	
	//@Override
	public void updateUserPassword(Integer id, String password) {
		int count = 0;
		List<Customer> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(id)){
				us.get(i).setPassword(password);
				count++;
			}
		}
		if(count==0){
			System.out.println("No user with that ID found");
		}
		
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
	
}
