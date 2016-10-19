package com.nbgardens.net_app;

import java.util.List;

public interface BasketManager {
	 public void persistBasket(Basket b);
	 public void persistBaskets (List<Basket> b);
	
	 public Basket findBasketById(Integer id);
	 
	 public void addToBasket(Basket b);
	 public void updateBasket(Basket b);
	 public void deleteFromBasket(Basket b);
}
