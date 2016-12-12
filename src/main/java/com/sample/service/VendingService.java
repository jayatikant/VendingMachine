package com.sample.service;

import java.util.List;

import com.sample.model.Inventory;
import com.sample.model.Product;

public class VendingService {

	private static final String NO_MONEY_RECEIVED = "NO_MONEY_RECEIVED";
	private static final String PRODUCT_UNAVAILABLE = "PRODUCT_UNAVAILABLE";
	private static final String PRODUCT_FOUND = "PRODUCT_FOUND";
	private static final String SPACE = " ";
	private static final String CURRENCY = "Rs.";
	private static final String INSUFFICIENT_MONEY_RECEIVED = "INSUFFICIENT_MONEY_RECEIVED";
	private static final String PURCHASE_SUCCESSFUL = "PURCHASE_SUCCESSFUL";
	private static final String PLEASE_SELECT_PRODUCT = "PLEASE_SELECT_PRODUCT";
	private List<Integer> coins;
	private String productCode;
	private Inventory inventory;
	private Product product;

	public VendingService(Inventory inventory) {
		this.inventory = inventory;
	}

	private String checkProductAvailability() {
		if (product.equals(Product.getEmptyProduct())
				|| product.getQuantity() == 0) {
			return PRODUCT_UNAVAILABLE;
		}
		return PRODUCT_FOUND + SPACE + product.getCode() + SPACE
				+ product.getCost() + CURRENCY;
	}

	public List<Integer> getCoins() {
		return coins;
	}

	public Product getProduct() {
		return product;
	}

	public String getProductCode() {
		return productCode;
	}

	private String purchaseProduct(List<Integer> coins) {
		int totalValue = 0;
		for (Integer value : coins) {
			totalValue += value;
		}
		if (totalValue < product.getCost()) {
			return INSUFFICIENT_MONEY_RECEIVED;
		}
		vendProduct();
		return PURCHASE_SUCCESSFUL;
	}

	public String setCoins(List<Integer> coins) {
		this.coins = coins;
		if (getCoins() == null) {
			return NO_MONEY_RECEIVED;
		}
		if (product == null) {
			return PLEASE_SELECT_PRODUCT;
		}
		return purchaseProduct(coins);
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String setProductCode(String productCode) {
		this.productCode = productCode;
		setProduct(inventory.getProduct(productCode));
		return checkProductAvailability();

	}

	private void vendProduct() {
		inventory.vendProduct(product);
	}

}
