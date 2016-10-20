package com.nbgardens.net_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.User;
import com.nbgardens.net_app.managers.UserManager;
import com.nbgardens.net_app.util.InitialData;

public class UserManagerOffline implements UserManager{
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistUser(User u) {
		initialData.addUser(u);
	}
	
	@Override
	public void persistUsers(List<User> u) {
		
	}
	
	@Override
	public User getUser(User u) {
		return u; 
	}
	@Override
	public List<User> getUsers() {

		return initialData.getUsers();
	}
	@Override
	public void updateUser(User u) {
		
	}
	@Override
	public void removeUser(User u) {
		
	}
}
