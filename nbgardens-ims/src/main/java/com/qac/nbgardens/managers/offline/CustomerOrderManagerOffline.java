package com.qac.nbgardens.managers.offline;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.managers.CustomerOrderManager;
import com.qac.nbgardens.entities.Customer;

@Default
@Stateless
public class CustomerOrderManagerOffline implements CustomerOrderManager {
	
	
	private Customer customer;
	
	@Override
	public Date returnOrderDate(Integer customerOrderID){
		int count = 0;
		Date orderDate;
		List<CustomerOrder> co = customer.getCustomerOrders();
		for(int i=0; i < co.size(); i++){
			if(co.get(i).getCustomerOrderId().equals(customerOrderID)){
				orderDate = co.get(i).getOrderDate();
				count++;
				return orderDate;
			}
		}
		if(count==0){
			System.out.println("No order with that ID found");
		}
		return null;
	}
	
	
	@Override
	public OrderStatus findOrderStatus(Integer customerOrderID){
		int count = 0;
		OrderStatus orderStatus;
		List<CustomerOrder> co = customer.getCustomerOrders();
		for(int i=0; i<co.size(); i++){
			if(co.get(i).getCustomerOrderId().equals(customerOrderID)){
				orderStatus = co.get(i).getStatus();
				count++;
				return orderStatus;
			}
		}
		if(count==0){
			System.out.println("No order with that ID found");
		}
		return null;
	}


	@Override
	public List<CustomerOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
