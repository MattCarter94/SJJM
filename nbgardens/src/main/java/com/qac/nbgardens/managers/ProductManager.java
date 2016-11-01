package com.qac.nbgardens.managers;

import java.util.ArrayList;
import java.util.List;

import com.qac.nbgardens.entities.Product;

public interface ProductManager {
	public void persistProduct(Product p);
	public void persistProducts(List<Product> p);
	
	public Product findProductById(Integer id);
	public ArrayList<Product> getProducts();
	
	public void updateProduct (Product p);
	public void removeProduct (Product p);
	public List<Product> findAll();
}
