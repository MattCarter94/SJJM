package com.qac.nbgardens.beans;

import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.SessionScoped;


@Named("prodbean")
@SessionScoped
public class ProductBean implements Serializable {
		private int id;
		private int priceLow;
		private int priceHigh;
//		private List<Integer> priceRange = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 75, 100));  
		private double[] priceRange2 = {10, 20, 30};

		
		
		
//		public List<Integer> getPriceRange() {
//			return priceRange;
//		}
//
//		public void setPriceRange(List<Integer> priceRange) {
//			this.priceRange = priceRange;
//		}

		public double[] getPriceRange2() {
			return priceRange2;
		}

		public void setPriceRange2(double[] priceRange2) {
			this.priceRange2 = priceRange2;
		}

		public int getPriceLow() {
			return priceLow;
		}

		public void setPriceLow(int priceLow) {
			this.priceLow = priceLow;
		}

		public int getPriceHigh() {
			return priceHigh;
		}

		public void setPriceHigh(int priceHigh) {
			this.priceHigh = priceHigh;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		
}