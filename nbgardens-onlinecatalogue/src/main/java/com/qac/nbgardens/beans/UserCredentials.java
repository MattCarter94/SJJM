package com.qac.nbgardens.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.WishlistProduct;
import com.qac.nbgardens.entities.enums.OrderStatus;
import com.qac.nbgardens.util.InitialData;

import javax.enterprise.inject.Alternative;

@Alternative
@Named("currentUser")
@SessionScoped
public class UserCredentials implements Serializable {
	
	@Inject
	InitialData initialData;
	
	private Customer user;
	private CustomerOrder basket;
	private BigDecimal total = new BigDecimal(0);
	private Integer deleteId;
	private List<CustomerOrder> userOrders;

	public boolean isLoggedIn() {
		return (user!=null)? true : false;
		/*
		 * if(user!=null)
		 *   return true;
		 * return false;  
		 */
	}
	
	public boolean hasOrders(){
		int count=0;
		List<CustomerOrder> order = new ArrayList<>();
		for(int i=0; i>initialData.getCustomerOrders().size(); i++){
			if(initialData.getCustomerOrders().get(i).getCustomer().getEmail() == user.getEmail() && initialData.getCustomerOrders().get(i).getStatus() == OrderStatus.INPROGRESS){
				order.add(initialData.getCustomerOrders().get(i));
				count++;
			}
			else if(initialData.getCustomerOrders().get(i).getCustomer().getEmail() == user.getEmail() && initialData.getCustomerOrders().get(i).getStatus() == OrderStatus.DISPATCHED){
				order.add(initialData.getCustomerOrders().get(i));
				count++;
			}
		}
		if(count>0){
			userOrders=order;
			return true;
		}
		else{
			return false;
		}
	}
	
	public void checkout(){
		basket.setStatus(OrderStatus.INPROGRESS);
	}
	
	public boolean itemInWishlist(Integer productID){
		WishlistProduct wlp = user.getWishlist();
		for(int i=0; i>wlp.getProducts().size(); i++){
			if(wlp.getProducts().get(i).getProductID() == productID){
				return true;
			}
		}
		return false;
	}
	
	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public CustomerOrder getBasket() {
		return basket;
	}

	public void setBasket(CustomerOrder basket) {
		this.basket = basket;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Integer getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}

	public List<CustomerOrder> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<CustomerOrder> userOrders) {
		this.userOrders = userOrders;
	}
	
	
	
}