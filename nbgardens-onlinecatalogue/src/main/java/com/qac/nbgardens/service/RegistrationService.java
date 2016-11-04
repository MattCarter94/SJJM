package com.qac.nbgardens.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.UserManager;

@Stateless
public class RegistrationService {
	@Inject
	private UserManager userManager;

	public boolean checkIfRegistered(String email) {
		Customer customer = userManager.getUserByEmail(email);
		if (customer.getEmail().equals(email))
			return false;
		return true;
	}

	public Customer getUserID(String user) {
		return userManager.getUserByEmail(user.toLowerCase());
	}
}
