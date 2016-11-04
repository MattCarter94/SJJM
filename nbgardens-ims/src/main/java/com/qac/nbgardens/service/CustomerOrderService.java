
package com.qac.nbgardens.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.managers.CustomerOrderManager;;

@Stateless
public class CustomerOrderService {
	@Inject
	private CustomerOrderManager customerOrderManager;

	public List<CustomerOrder> findAll() {
		return customerOrderManager.findAll();
	}
}
