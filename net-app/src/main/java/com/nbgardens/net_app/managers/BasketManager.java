package com.nbgardens.net_app.managers;

import java.util.List;

import com.nbgardens.net_app.entities.Basket;

public interface BasketManager {
	 public void persistBasket(Basket b);
	 public void persistBaskets (List<Basket> b);
	
	 public Basket findBasketById(Basket id);
	 
	 public void addToBasket(Basket b);
	 public void updateBasket(Basket b);
	 public void deleteFromBasket(Basket b);
}
