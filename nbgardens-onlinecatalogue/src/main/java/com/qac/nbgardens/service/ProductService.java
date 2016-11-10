package com.qac.nbgardens.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.managers.ProductManager;

@Stateless
public class ProductService {
	@Inject
	private ProductManager productManager;

	public List<Product> findAll() {
		return productManager.findAll();
	}
	
	public ArrayList<Product> findAll(double low, double high) {
//		System.out.println("service findAll");
		return productManager.findAll(low, high);
	}

	public Product findProductById(Integer id) {
		return productManager.findProductById(id);
	}

	public List<Double> priceRange() {
		List<Product> all = findAll();
		List<Double> prices = new ArrayList<>();
		for(int i=0; i<all.size(); i++){
			prices.add(all.get(i).getPrice());
			}
		Collections.sort(prices);
		return prices;
		}
		
	}

