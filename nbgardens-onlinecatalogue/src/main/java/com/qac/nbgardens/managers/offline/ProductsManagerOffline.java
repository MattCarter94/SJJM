package com.qac.nbgardens.managers.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.managers.ProductManager;
import com.qac.nbgardens.util.InitialData;

@Stateless
@Default
public class ProductsManagerOffline implements ProductManager{

	@Inject
	private InitialData initialData;
	
	@Override
	public void persistProduct(Product p) {
		initialData.addProduct(p);
	}
	@Override
	public void persistProducts(List<Product> p) {
		for (Product pr : p) {
			
			initialData.addProduct(pr);
		}
	}
	
	@Override
	public Product findProductById(Integer id) {
		List<Product> products = initialData.getProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductID().equals(id)) {
				return products.get(i);
			}
		}
		return null;
	}
	@Override
	public ArrayList<Product> getProducts() {

		return initialData.getProducts();
	}
	@Override
	public void updateProduct(Product p) {
		List<Product> products = initialData.getProducts();
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getProductID() == p.getProductID()) {
				products.set(i, p);
			}
		}
	}
	@Override
	public void removeProduct(Product p) {
		//TODO left blank for now
	}
	@Override
	public List<Product> findAll() {
		return initialData.getProducts();
	}
	@Override
	public ArrayList<Product> findAll(double low, double high, Category category, String search) {
		return initialData.getProducts(low, high, category, search);
	}
	@Override
	public ArrayList<Product> findAll(String search) {
		return initialData.getProducts(search);
	}
}