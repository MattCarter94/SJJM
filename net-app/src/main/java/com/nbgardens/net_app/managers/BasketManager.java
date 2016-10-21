package com.nbgardens.net_app.managers;

import java.math.BigDecimal;
import com.nbgardens.net_app.entities.Basket;

public interface BasketManager {
	public Basket getBasket(Integer basketID);
	public Basket getBasketGivenUser(Integer userID);
	public BigDecimal getTotalPriceGivenUser(Integer userID);
	public BigDecimal getTotalPrice(Integer basketID);
	
}
