
package com.qac.nbgardens.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.managers.CustomerManager;;

@Stateless
public class CustomerService {
	@Inject
	private CustomerManager customerManager;

	public List<Customer> findAll() {
		return customerManager.findAll();
	}
}
