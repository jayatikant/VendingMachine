package com.sample.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {
	List<Product> products = new ArrayList<Product>();
	Inventory inventory = new Inventory();

	@Test
	public void addProducts_initializesProductsWhenListPassedIsEmpty() {
		inventory.addProducts(products);
		Assert.assertEquals(inventory.getProducts().size(), 0);
	}

	@Test
	public void addProducts_singleProductAddedSuccessfully() {
		Product e = new Product("COMP");
		products.add(e);
		inventory.addProducts(products);
		Assert.assertEquals(inventory.getProducts().size(), 1);
	}

	@Test
	public void getProduct_returnEmptyProductIfProductDoesNotExists() {
		Assert.assertEquals(Product.getEmptyProduct(),
				inventory.getProduct("RSP"));
	}

	@Test
	public void getProduct_returnProductIfProductExists() {
		Product product = new Product("11", 11, 11);
		inventory.addProduct(product);
		Assert.assertEquals(product, inventory.getProduct("11"));
	}

}
