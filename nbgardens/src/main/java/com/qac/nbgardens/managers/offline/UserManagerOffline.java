package com.qac.nbgardens.managers.offline;

import java.util.List;

import javax.inject.Inject;

import com.qac.nbgardens.entities.Basket;
import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.User;
import com.qac.nbgardens.entities.Wishlist;
import com.qac.nbgardens.managers.UserManager;
import com.qac.nbgardens.util.InitialData;

public class UserManagerOffline implements UserManager{
	@Inject
	private InitialData initialData;
	
	
	public void persistUser(CardDetails card, Wishlist wishlist, Basket basket, String name, String surname, String email, String phoneNo, String password, Integer permissions, String add1, String add2, String town, String county, String postcode) {
		User u = new User(card, wishlist, basket, name, surname, email, phoneNo, password, permissions, add1, add2, town, county, postcode);
		initialData.addUser(u);
	}
	
	

	public User getUser(Integer id) {
		List<User> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(id)){
				return us.get(i);
			}
		}
		return null;
		
	}
	
	public List<User> getUsers() {
		return initialData.getUsers();
	}
	
	
	
	public void updateUserEmail(Integer id, String email) {
		int count = 0;
		List<User> us = initialData.getUsers();
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
		List<User> us = initialData.getUsers();
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
		List<User> us = initialData.getUsers();
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
	
}
