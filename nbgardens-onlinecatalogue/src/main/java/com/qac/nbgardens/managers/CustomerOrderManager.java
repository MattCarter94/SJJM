package com.qac.nbgardens.managers;

import java.util.Date;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;

public interface CustomerOrderManager {

	public Date returnOrderDate(Integer customerOrderID);
	public OrderStatus findOrderStatus(Integer customerOrderID);

	public CustomerOrder getBasketGivenUser(Integer userID);
	public CustomerOrder getBasketGivenEmail(String email);
	public void updateUserBasket(CustomerOrder basket, int idx);
	public void updateCheckoutBasket(CustomerOrder newBasket, int idx, CustomerOrder basket);
}
