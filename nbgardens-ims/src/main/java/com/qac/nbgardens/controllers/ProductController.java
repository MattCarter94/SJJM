package com.qac.nbgardens.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;
import com.qac.nbgardens.service.ProductService;
import com.qac.nbgardens.util.Pagination;


@Named("products")
@SessionScoped
public class ProductController implements Serializable{
	@Inject
	private ProductService productService;
	private DataModel<Product> products = null;
	private Pagination pagination;
	
	public float calculateStockLevel(Integer id) {
		return productService.calculatePercentageStock(id);
	}
	
	public void updateProduct(Integer id) {
		String title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_title");
		String price = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_price");
		String description = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_description");
		String category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("j_idt15:0:details:j_idt18");
		String image = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_image");
		String tags = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_tags");
		String stock = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_stock");
		String active = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("j_idt15:0:details:j_idt21");
		productService.updateProduct(id, title, price, description, category, image, tags, stock, active);
	}
	
	public SelectItem[] getActiveValues() {
		SelectItem[] items = new SelectItem[ProductStatus.values().length];
		int i = 0;
		for (ProductStatus ps : ProductStatus.values()) {
			items[i++] = new SelectItem(ps, ps.toString());
		}
		return items;
	}
	
	public SelectItem[] getCategoryValues() {
		SelectItem[] items = new SelectItem[Category.values().length];
		int i = 0;
		for (Category c : Category.values()) {
			items[i++] = new SelectItem(c, c.toString());
		}
		return items;
	}
	
	public String next() {
		getPagination().nextPage();
		recreateModel();
		return "products";
	}
	
	public String previous() {
		getPagination().previousPage();
		recreateModel();
		return "products";	
	}
	
	private void recreateModel() {
		products = null;
	}

	public DataModel<Product> getProducts() {
		if(products == null)
			products = getPagination().createDataModel();
		return products;
	}

	private Pagination getPagination() {
		if(pagination==null)
			pagination = new Pagination(20) {
				
				@Override
				public DataModel createDataModel() {
					try {
						return new ListDataModel<Product>(productService.findAll().subList(getPageFirstItem(), getPageFirstItem() + getPageSize()));
					} catch (Exception e) {
						return new ListDataModel<Product>(productService.findAll().subList(getPageFirstItem(), getItemsCount()));
					}
				}

				@Override
				public int getItemsCount() {
					return productService.findAll().size();
				}
			};
		return pagination;
	}
}

