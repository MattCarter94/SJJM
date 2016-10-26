package com.qac.nbgardens.managers.offline;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import com.qac.nbgardens.entities.Basket;
import com.qac.nbgardens.entities.User;
import com.qac.nbgardens.managers.BasketManager;
import com.qac.nbgardens.util.InitialData;

public class BasketManagerOffline implements BasketManager {
	
	@Inject
	private InitialData initialData;
	
	@Override //Get basket given a known basket ID
	public Basket getBasket(Integer basketID) {
		List<Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++){
			if(bs.get(i).getBasketID().equals(basketID)){
				return bs.get(i);
			}
		}
		return null;
	}
	
	
	@Override //Get basket given a user ID
	public Basket getBasketGivenUser(Integer userID) {
		List<User> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(userID)){
				return us.get(i).getBasket();
			}
		}
		return null;
	}
	
	
	@Override //Get total price of basket contents given a user ID
	public BigDecimal getTotalPriceGivenUser(Integer userID) {
		BigDecimal totalPrice;
		List<User> us = initialData.getUsers();
		for(int i=0; i<us.size(); i++){
			if(us.get(i).getUserID().equals(userID)){
				totalPrice = us.get(i).getBasket().getTotalPrice();
				return totalPrice;
			}
		}
		return null;
	}
	
	
	@Override //Get total price of basket contents given basket ID
	public BigDecimal getTotalPrice(Integer basketID) {
		BigDecimal totalPrice;
		List<Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++){
			if(bs.get(i).getBasketID().equals(basketID)){
				totalPrice = bs.get(i).getTotalPrice();
				return totalPrice;
			}
		}
		return null;
	}

}
