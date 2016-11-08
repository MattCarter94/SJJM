package com.qac.nbgardens.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;
import com.qac.nbgardens.managers.ProductManager;

@Stateless
public class AddProductService {
	@Inject
	private ProductManager productManager;

	public List<Product> findAll() {
		return productManager.findAll();
	}
	
	
	
	public void addProduct(Integer id, String title, String price, String description, String category, String image, String tags, String stock, String active, Date orderDate) {
		double nPrice = Double.parseDouble(price);
		Category c = Category.GNOME;
		switch (category) {
		case "GNOME":
			c =Category.GNOME;
			break;
		case "GNOMEACCESSORY":
			c = Category.GNOMEACCESSORY;
			break;
		case "GARDENFOUNTIAN":
			c = Category.GARDENFOUNTIAN;
			break;
		}
		Integer nStock = Integer.parseInt(stock);
		ProductStatus a = ProductStatus.ACTIVE;
		switch (active) {
		case "ACTIVE":
			a = ProductStatus.ACTIVE;
			break;
		case "DISCONTINUED":
			a = ProductStatus.DISCONTINUED;
			break;
		}
		
		Product p = new Product(title, nPrice, description, c, image, tags, nStock, a);
		
		productManager.addProduct(p);
		
		for (Product d : productManager.getProducts()) {
			System.out.println(d.getTitle() + " : " + d.getProductId() + d.getCategory().toString() + d.getState().toString());
		}
	}
	
	
	public Product findProductById(int id){
		return productManager.findProductById(id);
	}
	
}
