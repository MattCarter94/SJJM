package com.qac.nbgardens.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.managers.CustomerOrderManager;
import com.qac.nbgardens.managers.UserManager;

@Stateless
public class LoginService {
	@Inject
	private UserManager userManager;
	@Inject
	private CustomerOrderManager customerOrderManager;

	public boolean validateDetails(String email, String pass) {
		Customer customer = userManager.getUserByEmail(email);
		if (customer != null && customer.getPassword().equals(pass))
			return true;
		return false;
	}

	public Customer getUserID(String user) {
		return userManager.getUserByEmail(user.toLowerCase());
	}

	public CustomerOrder getBasket(String email) {
		return customerOrderManager.getBasketGivenEmail(email);
	}
}
