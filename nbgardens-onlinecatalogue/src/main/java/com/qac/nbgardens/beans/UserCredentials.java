package com.qac.nbgardens.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.qac.nbgardens.entities.Customer;
import com.qac.nbgardens.entities.CustomerOrder;
import com.qac.nbgardens.entities.WishlistProduct;
import javax.enterprise.inject.Alternative;

@Alternative
@Named("currentUser")
@SessionScoped
public class UserCredentials implements Serializable {
	
	private Customer user;
	private CustomerOrder basket;
	private List<CustomerOrder> userOrders = null;

	public boolean isLoggedIn() {
		return (user!=null)? true : false;
		/*
		 * if(user!=null)
		 *   return true;
		 * return false;  
		 */
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

	public List<CustomerOrder> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<CustomerOrder> userOrders) {
		this.userOrders = userOrders;
	}
	
	
	
}