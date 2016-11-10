package com.qac.nbgardens.controllers;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import com.qac.nbgardens.entities.Product;
 
@ManagedBean
@Named("chartView")
public class ChartView implements Serializable {
 
	@Inject
	private ProductController productController;
	
	private Product product;
    private LineChartModel lineModel1;
    //private Integer id = 1000;
	private Integer graphSearch;
	private String  errorMsg;

	@PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
 
     
    private String createLineModels() {
        lineModel1 = initLinearModel();
        Integer userEnteredId = 1000;
        try{
        	userEnteredId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("filter_search"));
        	if(userEnteredId < productController.getProducts().get(0).getProductId() || userEnteredId > productController.getProducts().get(productController.getProducts().size() - 1).getProductId()){
        		System.out.println("Out of range value");
        		errorMsg = "No products with this ID found.";
        		userEnteredId = 1000;
        		return "LiveStockReport";
        	}
        
        } catch(Exception e) {
        	System.out.println("Exception met");
        }
        product = productController.findProductById(userEnteredId);
        //System.out.println(String.format("Product Updated- ID: %s | Title: %s | Price: £%s | Description: %s | Category: %s | Image: %s | Tags: %s | Stock: %s | Active: %s |", id, product.getTitle(), product.getPrice(), product.getDescription(), product.getCategory().toString(), product.getImage(), product.getTags(), product.getStock(), product.getState().toString()));
		
        lineModel1.setTitle("Product: " + product.getTitle() + " | ID: " + product.getProductId()); //Product title here
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Monthly Sales Report"));
        yAxis.setMin(0);
        yAxis.setMax(500);
         return "LiveStockReport";
        
    }
     
    public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        
        series1.setLabel("Series 1");
 
        series1.set("Jan 2016", 201);
        series1.set("Feb 2016", 150);
        series1.set("Mar 2016", 384);
        series1.set("Apr 2016", 400);
        series1.set("May 2016", 390);
        series1.set("Jun 2016", 365);
        series1.set("Jul 2016", 354);
        series1.set("Aug 2016", 320);
        series1.set("Sep 2016", 299);
        series1.set("Oct 2016", 302);
        series1.set("Nov 2016", 370);
        series1.set("Dec 2016", 478);
        
        series1.set("Jan 2017", 512);
 
        model.addSeries(series1);
      
         
        return model;
    }
     
    private LineChartModel initCategoryModel() {

    	return null;
    }
 
}