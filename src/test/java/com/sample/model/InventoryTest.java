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
	public void addProduct_singleProductAddedSuccessfully(){
		Product e = new Product("COMP");
		products.add(e);
		inventory.addProducts(products);
		Assert.assertEquals(inventory.getProducts().size(), 1);
		
	}
}
