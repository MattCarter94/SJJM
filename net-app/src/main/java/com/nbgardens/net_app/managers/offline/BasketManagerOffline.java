package com.nbgardens.net_app.managers.offline;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.Basket;
import com.nbgardens.net_app.entities.User;
import com.nbgardens.net_app.managers.BasketManager;
import com.nbgardens.net_app.util.InitialData;

public class BasketManagerOffline implements BasketManager {
	
	@Inject
	private InitialData initialData;
	
	@Override
	public Basket getBasket(Integer basketID) {
		List<Basket> bs = initialData.getBaskets();
		for(int i=0; i<bs.size(); i++){
			if(bs.get(i).getBasketID().equals(basketID)){
				return bs.get(i);
			}
		}
		return null;
	}
	
	
	@Override
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
