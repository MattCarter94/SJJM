package com.nbgardens.net_app.managers;

import java.util.List;

import com.nbgardens.net_app.entities.User;

public interface UserManager {
	public void persistUser(User u);
	public void persistUsers(List<User> u);
	public User getUser(Integer id);
	public List<User> getUsers();
	
	public void updateUser(User u);
	public void removeUser(User u);
}
