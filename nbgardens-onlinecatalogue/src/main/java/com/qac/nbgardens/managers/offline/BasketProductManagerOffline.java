package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.qac.nbgardens.entities.BasketProduct;
import com.qac.nbgardens.managers.BasketProductManager;

@Default
@Stateless
public class BasketProductManagerOffline implements BasketProductManager{
	@Override
	public void persistBasketProduct (BasketProduct a){
		
	}
	@Override
	public void persistBasketProduct (List<BasketProduct> a){
		
	}
	@Override
	public ArrayList<BasketProduct> getBasketProduct(){
		return new ArrayList<BasketProduct>();
		
	}
	@Override
	public void updateBasketProduct (BasketProduct a){
		
	}
	@Override
	public void removeBasketProduct (BasketProduct a){
		
	}
}
