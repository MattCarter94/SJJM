package com.qac.nbgardens.managers;

import java.util.List;

import com.qac.nbgardens.entities.Basket;
import com.qac.nbgardens.entities.CardDetails;
import com.qac.nbgardens.entities.User;
import com.qac.nbgardens.entities.Wishlist;

public interface UserManager {
	public void persistUser(CardDetails card, Wishlist wishlist, Basket basket, String name, String surname, String email, String phoneNo, String password, Integer permissions, String add1, String add2, String town, String county, String postcode);
	public User getUser(Integer id);
	public List<User> getUsers();
	
	public void updateUserEmail(Integer id, String email);
	public void updateUserPhoneNo(Integer id, String phoneNo);
	public void updateUserPassword(Integer id, String password);
}