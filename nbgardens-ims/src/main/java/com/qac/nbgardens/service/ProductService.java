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
	
	public void updateProduct(Product p) {
		productManager.findProductById(p.getProductID()).setTitle(p.getTitle());
		productManager.findProductById(p.getProductID()).setDescription(p.getDescription());
		productManager.findProductById(p.getProductID()).setImage(p.getImage());
		productManager.findProductById(p.getProductID()).setPrice(p.getPrice());
		productManager.findProductById(p.getProductID()).setStock(p.getStock());
		if (productManager.findProductById(p.getProductID()).getStock() > productManager.findProductById(p.getProductID()).getMaxStock()) {
			productManager.findProductById(p.getProductID()).setMaxStock(p.getStock());
		}
		productManager.findProductById(p.getProductID()).setTags(p.getTags());
		
	}
	
	
	public Integer calculatePercentageStock(Integer id) {
		Product product = productManager.findProductById(id);
		return (int)((float)product.getStock() / (float)product.getMaxStock()) * 100;	
	}
	
	
	public Product findProductById(int id){
		return productManager.findProductById(id);
		
	}
	
}
