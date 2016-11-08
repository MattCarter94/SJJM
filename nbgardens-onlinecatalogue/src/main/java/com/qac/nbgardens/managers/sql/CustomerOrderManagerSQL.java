package com.qac.nbgardens.managers.sql;

import java.util.Date;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.CustomerOrderManager;

@Alternative
@Stateless
public class CustomerOrderManagerSQL  implements CustomerOrderManager{

	@Override
	public Date returnOrderDate(Integer customerOrderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatus findOrderStatus(Integer customerOrderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOrder getBasketGivenUser(Integer userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOrder getBasketGivenEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserBasket(CustomerOrder basket, int idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCheckoutBasket(CustomerOrder newBasket, int idx, CustomerOrder basket) {
		// TODO Auto-generated method stub
		
	}

}
