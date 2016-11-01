package com.qac.nbgardens.managers;

import java.math.BigDecimal;

import com.qac.nbgardens.entities.Basket;

public interface BasketManager {
	public Basket getBasket(Integer basketID);
	public Basket getBasketGivenUser(Integer userID);
	public BigDecimal getTotalPriceGivenUser(Integer userID);
	public BigDecimal getTotalPrice(Integer basketID);
	
}
