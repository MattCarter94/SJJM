package com.nbgardens.net_app.managers;

import java.util.List;

import com.nbgardens.net_app.entities.Basket;
import com.nbgardens.net_app.entities.CardDetails;
import com.nbgardens.net_app.entities.User;
import com.nbgardens.net_app.entities.Wishlist;

public interface UserManager {
	public void persistUser(CardDetails card, Wishlist wishlist, Basket basket, String name, String surname, String email, String phoneNo, String password, Integer permissions, String add1, String add2, String town, String county, String postcode);
	public User getUser(Integer id);
	public List<User> getUsers();
	
	public void updateUserEmail(Integer id, String email);
	public void updateUserPhoneNo(Integer id, String phoneNo);
	public void updateUserPassword(Integer id, String password);
}
