package com.qac.nbgardens.service;

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
	
	
	public Integer calculatePercentageStock(Integer id) {
		Product product = productManager.findProductById(id);
		return (int)((float)product.getStock() / (float)product.getMaxStock()) * 100;	
	}
	
}
