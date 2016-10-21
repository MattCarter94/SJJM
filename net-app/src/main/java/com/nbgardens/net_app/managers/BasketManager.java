package com.nbgardens.net_app.managers;

import java.math.BigDecimal;
import java.util.List;

import com.nbgardens.net_app.entities.Basket;

public interface BasketManager {
	public Basket getBasket(Integer basketID);
	public BigDecimal getTotalPrice(Integer basketID);
	
}
