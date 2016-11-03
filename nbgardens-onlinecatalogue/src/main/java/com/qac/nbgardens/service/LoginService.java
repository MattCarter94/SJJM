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

	public boolean validateDetails(String email, String pass) {
		Customer customer = userManager.getUserByEmail(email);
		if (customer != null && customer.getPassword().equals(pass))
			return true;
		return false;
	}

	public Customer getUserID(String user) {
		return userManager.getUserByEmail(user.toLowerCase());
	}
}
