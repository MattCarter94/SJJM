package com.nbgardens.net_app;

import java.util.ArrayList;
import java.util.List;

public interface UserManager {
	public void persistUser(User u);
	public void persistUsers(List<User> u);
	
	public User findById(Integer id);
	public ArrayList<User> getUsers();
	
	public void updateUser(User u);
	public void removeUser(User u);
}
