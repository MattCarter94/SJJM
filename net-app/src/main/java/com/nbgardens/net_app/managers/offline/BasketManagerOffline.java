package com.nbgardens.net_app.managers.offline;

import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.Basket;
import com.nbgardens.net_app.managers.BasketManager;
import com.nbgardens.net_app.util.InitialData;

public class BasketManagerOffline implements BasketManager {
	
	@Inject
	private InitialData initialData;
	
	@Override
	public void persistBasket(Basket b) {
		initialData.addToBasket(b);
	}
	@Override
	public void persistBaskets (List<Basket> b) {
		
	}
	
	@Override
	public Basket findBasketById(Basket id) {
		return id; //TODO
	}
	
	@Override
	public void addToBasket(Basket b) {
		 
	}
	
	@Override
	public void updateBasket(Basket b) {
		 
	}
	
	@Override
	public void deleteFromBasket(Basket b) {
		 
	}
}
