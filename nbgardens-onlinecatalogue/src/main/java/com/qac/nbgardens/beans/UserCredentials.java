package com.qac.nbgardens.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;

@Named("currentUser")
@SessionScoped
public class UserCredentials implements Serializable {
	private Customer user;

	public boolean isLoggedIn() {
		return (user!=null)? true : false;
		/*
		 * if(user!=null)
		 *   return true;
		 * return false;  
		 */
	}
	
	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}
}