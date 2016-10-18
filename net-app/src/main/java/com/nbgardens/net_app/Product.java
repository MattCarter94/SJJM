package com.nbgardens.net_app;

import java.util.Currency;

public class Product {
	private enum Category{
		Gnome, GnomeAccessory, GardenEquipment
	};
	private enum State{
		Active, Discontinued
	};
	
	private Integer productID;
	private String title;
	private Currency price;
	private String description;
	private Category category;
	private String image;
	private String[] tags;
	private Integer stock;
	private State state;
}
