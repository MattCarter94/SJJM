package com.nbgardens.net_app.managers.offline;

import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.Basket;
import com.nbgardens.net_app.entities.CardDetails;
import com.nbgardens.net_app.entities.User;
import com.nbgardens.net_app.entities.Wishlist;
import com.nbgardens.net_app.managers.UserManager;
import com.nbgardens.net_app.util.InitialData;

public class UserManagerOffline implements UserManager{
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistUser(CardDetails card, Wishlist wishlist, Basket basket, String name, String surname, String email, String phoneNo, String password, Integer permissions, String add1, String add2, String town, String county, String postcode) {
		User u = new User(card, wishlist, basket, name, surname, email, phoneNo, password, permissions, add1, add2, town, county, postcode);
		initialData.addUser(u);
	}
	
	
	@Override
	public User getUser(Integer id) {
		List<User> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(id)){
				return us.get(i);
			}
		}
		return null;
		
	}
	@Override
	public List<User> getUsers() {
		return initialData.getUsers();
	}
	
	
	@Override
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
