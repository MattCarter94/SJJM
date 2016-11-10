package com.qac.nbgardens.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;
import com.qac.nbgardens.managers.ProductManager;

@Stateless
public class ProductService {
	@Inject
	private ProductManager productManager;

	public List<Product> findAll() {
		return productManager.findAll();
	}
	
	public void updateProduct(Integer id, String title, String price, String description, String category, String image, String tags, String stock, String active) {
		productManager.findProductById(id).setTitle(title);
		double nPrice = Double.parseDouble(price);
		productManager.findProductById(id).setPrice(nPrice);
		productManager.findProductById(id).setDescription(description);
		//System.out.println("category: " + category);
		switch (category) {
		case "GNOME":
			productManager.findProductById(id).setCategory(Category.GNOME);
			break;
		case "GNOMEACCESSORY":
			productManager.findProductById(id).setCategory(Category.GNOMEACCESSORY);
			break;
		case "GARDENFOUNTAIN":
			productManager.findProductById(id).setCategory(Category.GARDENFOUNTAIN);
			break;
		}
		
		productManager.findProductById(id).setImage(image);
		productManager.findProductById(id).setTags(tags);
		Integer nStock = Integer.parseInt(stock);
		if (nStock > productManager.findProductById(id).getMaxStock()) {
			productManager.findProductById(id).setMaxStock(nStock);
		}
		productManager.findProductById(id).setStock(nStock);
		switch (active) {
		case "ACTIVE":
			productManager.findProductById(id).setState(ProductStatus.ACTIVE);
			break;
		case "DISCONTINUED":
			productManager.findProductById(id).setState(ProductStatus.DISCONTINUED);
			break;
		}
		//System.out.println("active: " + active);
	}
	
	
	
	public float calculatePercentageStock(Integer id) {
		Product product = productManager.findProductById(id);
		return ((float)product.getStock() / (float)product.getMaxStock()) * 100f;	
	}
	
	
	public Product findProductById(int id){
		return productManager.findProductById(id);
	}
	
}
