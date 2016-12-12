package com.sample.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public Product getProduct(String productCode) {
		Product product = new Product(productCode);
		return (products != null && products.indexOf(product) >= 0) ? products
				.get(products.indexOf(product)) : Product.getEmptyProduct();
	}

	public void addProducts(List<Product> products) {
		if (products != null) {
			if (this.products == null) {
				this.products = new ArrayList<Product>();
			}
			this.products.addAll(products);
		}
	}

	public void addProduct(Product product) {
		if (product != null) {
			if (this.products == null) {
				this.products = new ArrayList<Product>();
			}
			this.products.add(product);
		}
	}

	public void vendProduct(Product product) {
		if (this.products != null) {
			Product productFound = products.get(products.indexOf(product));
			productFound.setQuantity(productFound.getQuantity()-1);
		}
	}
}
