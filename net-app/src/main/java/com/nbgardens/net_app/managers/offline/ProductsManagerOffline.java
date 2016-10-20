package com.nbgardens.net_app.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.nbgardens.net_app.entities.Product;
import com.nbgardens.net_app.entities.User;
import com.nbgardens.net_app.managers.ProductManager;
import com.nbgardens.net_app.util.InitialData;

public class ProductsManagerOffline implements ProductManager{

	@Inject
	private InitialData initialData;
	
	@Override
	public void persistProduct(Product p) {
		
	}
	@Override
	public void persistProducts(List<Product> p) {
		
	}
	
	@Override
	public Product findProductById(Product product) {
		return product; 
	}
	@Override
	public ArrayList<Product> getProducts() {

		return initialData.getProducts();
	}
	@Override
	public void updateProduct(Product p) {
		
	}
	@Override
	public void removeProduct(Product p) {
		
	}
	
	
}
