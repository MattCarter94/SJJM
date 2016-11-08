package com.qac.nbgardens.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.beans.UserCredentials;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.util.InitialData;

@Stateless
public class AccountService {

	@Inject
	UserCredentials userCredentials;
	@Inject
	InitialData initialData;
	
	public boolean hasorders(){
		int count=0;
		List<CustomerOrder> orders = new ArrayList<CustomerOrder>();
		List<CustomerOrder> savedOrders = initialData.getCustomerOrders();
		System.out.println("found " + savedOrders.size() + " orders");
		for(int i=0; i<=savedOrders.size()-1; i++){
			if(savedOrders.get(i).getCustomer().getEmail() == userCredentials.getUser().getEmail() && savedOrders.get(i).getStatus() == OrderStatus.INPROGRESS){
				orders.add(savedOrders.get(i));
				count++;
			}
			else if(savedOrders.get(i).getCustomer().getEmail() == userCredentials.getUser().getEmail() && savedOrders.get(i).getStatus() == OrderStatus.DISPATCHED){
				orders.add(savedOrders.get(i));
				count++;
			}
		}
		if(count>0){
			userCredentials.setUserOrders(orders);
			return true;
		}
		else{
			return false;
		}
	}
	
}



