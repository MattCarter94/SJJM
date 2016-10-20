package com.nbgardens.net_app;

import java.util.List;

import javax.inject.Inject;

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
