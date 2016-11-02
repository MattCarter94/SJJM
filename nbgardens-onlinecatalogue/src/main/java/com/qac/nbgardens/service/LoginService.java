package com.qac.nbgardens.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.UserManager;

@Stateless
public class LoginService {
	@Inject
	private UserManager userManager;

	public boolean validateDetails(String user, String pass) {
		List<Customer> customers = userManager.getUserListByEmail(user);
		for(Customer c : customers)
			if(c.getPassword().equals(pass))
				return true;
		return false;
	}

	public Customer getUserID(String user) {
		return userManager.getUserByEmail(user.toLowerCase());
	}
}
