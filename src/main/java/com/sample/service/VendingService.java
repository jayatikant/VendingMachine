package com.sample.service;

import java.util.List;

import com.sample.model.Inventory;

public class VendingService {

	
	private List<Integer> coins;
	private String productCode;
	private Inventory inventory;

	public VendingService(Inventory inventory) {
		this.inventory = inventory;
	}

	public List<Integer> getCoins() {
		return coins;
	}

	public void setCoins(List<Integer> coins) {
		this.coins = coins;
	}

	public String getProductCode() {
		return productCode;
	}

	public String setProductCode(String productCode) {
		this.productCode = productCode;
		return "";
		
	}

	public Integer getProductCost() {
		
		return inventory.getProduct(productCode).getCost();
	}

	public void vendProduct() {

	}

}
