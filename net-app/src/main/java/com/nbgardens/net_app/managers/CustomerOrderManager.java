package com.nbgardens.net_app.managers;

import java.util.ArrayList;
import java.util.List;

import com.nbgardens.net_app.entities.CustomerOrder;

public interface CustomerOrderManager {

		public void persistCustomerOrder(CustomerOrder c);
		
		public void persistCustomerOrders(List<CustomerOrder> c);
		
		public CustomerOrder findById(Integer id);
		
		public ArrayList<CustomerOrder> getCustomerOrders();
		
		public void updateCustomerOrder(CustomerOrder s);
		
		public void removeCustomerOrder(CustomerOrder c);
		
}
