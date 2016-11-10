package com.qac.nbgardens.beans;

import javax.inject.Named;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;


@Named("prodbean")
@SessionScoped
public class ProductBean implements Serializable {
		private int id;
				
		
		
//		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		
}