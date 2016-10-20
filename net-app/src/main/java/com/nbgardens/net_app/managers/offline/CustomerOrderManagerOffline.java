package com.nbgardens.net_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import com.nbgardens.net_app.entities.CustomerOrder;
import com.nbgardens.net_app.managers.CustomerOrderManager;

public class CustomerOrderManagerOffline implements CustomerOrderManager {
	
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistCustomerOrder(CustomerOrder c){
		
	}
	@Override
	public void persistCustomerOrders(List<CustomerOrder> c) {
		
	}
	@Override
	public CustomerOrder findById(CustomerOrder co) {
		return co;
	}
	@Override
	public ArrayList<CustomerOrder> getCustomerOrders() {
		return new ArrayList<CustomerOrder>();
	}
	@Override
	public void updateCustomerOrder(CustomerOrder s) {
		
	}
	@Override
	public void removeCustomerOrder(CustomerOrder c) {
		
	}
	
}
