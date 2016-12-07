package com.sample.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Product> products;
	

	public List<Product> getProducts() {
		return products;
	}

	public Product getProduct(String productCode) {
		return null;
	}

	public void addProducts(List<Product> products) {
		if (products != null) {
		  if (this.products == null) {
			this.products = new ArrayList<Product>();
		}
			this.products.addAll(products);
		}
	}

	
}
