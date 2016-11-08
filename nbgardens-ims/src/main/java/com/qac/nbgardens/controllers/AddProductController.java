package com.qac.nbgardens.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbgardens.entities.Product;
import com.qac.nbgardens.entities.enums.Category;
import com.qac.nbgardens.entities.enums.ProductStatus;
import com.qac.nbgardens.service.AddProductService;
import com.qac.nbgardens.service.ProductService;
import com.qac.nbgardens.util.Pagination;


@Named("addproduct")
@SessionScoped
public class AddProductController implements Serializable{
	@Inject
	private AddProductService productService;
	
	
	
	public String addProduct() {
		List<String> listParameters = new ArrayList<>();
		FacesContext.getCurrentInstance().getExternalContext().getRequestParameterNames().forEachRemaining(k->{
			listParameters.add(k);
		});
		String category = "";
		String active = "";
		for(String property : listParameters) {
			//System.out.println(property);
			if(property.contains("j_idt15"))
				category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
			if(property.contains("j_idt18"))
				active = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(property);
		}
		String title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_title");
		String price = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_price");
		String description = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_description");
		//System.out.println("CATEGORY: " + category);
		String image = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_image");
		String tags = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_tags");
		String stock = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("product_stock");
		//System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
		//System.out.println(title + ", " + price + ", " + description + ", " + category + ", " + image + ", " + tags + ", " + stock + ", " + active);
		productService.addProduct(title, price, description, category, image, tags, stock, active, new Date());
		//productService.addProduct(105, title, price, description, category, image, tags, stock, active, new Date());
		return "products";
	}
	

}

