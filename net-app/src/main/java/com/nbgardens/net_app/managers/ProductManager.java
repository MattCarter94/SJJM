package com.nbgardens.net_app.managers;

import java.util.ArrayList;
import java.util.List;

import com.nbgardens.net_app.entities.Product;

public interface ProductManager {
	public void persistProduct(Product p);
	public void persistProducts(List<Product> p);
	
	public Product findProductById(Product product);
	public ArrayList<Product> getProducts();
	
	public void updateProduct (Product p);
	public void removeProduct (Product p);
}
