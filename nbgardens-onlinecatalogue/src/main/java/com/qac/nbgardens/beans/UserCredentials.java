package com.qac.nbgardens.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;

import javax.enterprise.inject.Alternative;

@Alternative
@Named("currentUser")
@SessionScoped
public class UserCredentials implements Serializable {
	private Customer user;
	private CustomerOrder basket;

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

	public CustomerOrder getBasket() {
		return basket;
	}

	public void setBasket(CustomerOrder basket) {
		this.basket = basket;
	}
	
	
}