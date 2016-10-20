package com.nbgardens.net_app.managers;

import java.util.ArrayList;
import java.util.List;

import com.nbgardens.net_app.entities.BasketProduct;

public interface BasketProductManager {
	
	public void persistBasketProduct (BasketProduct a);
	public void persistBasketProduct (List<BasketProduct> a);
	
	//public BasketProduct findByBasketProductId(String BasketProductId);
	
	public ArrayList<BasketProduct> getBasketProduct();
	
	public void updateBasketProduct (BasketProduct a);
	public void removeBasketProduct (BasketProduct a);
}
	
