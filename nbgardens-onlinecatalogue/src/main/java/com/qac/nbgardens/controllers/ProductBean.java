package com.qac.nbgardens.controllers;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="prodbean")
@SessionScoped
public class ProductBean {

		public int id;
		
		//Constructor
		public ProductBean() {
			
		}

		
		//get value from f:param
//		public int getIdParam(FacesContext fc){
//
//			Map<int,int> params = fc.getExternalContext().getRequestParameterMap();
//			return params.get("country");
//
//		}
//		
		
		//Getters and Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		
}
