package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sample.model.Inventory;
import com.sample.model.Product;

public class VendingServiceTest {
	private static final String PRODUCT_UNAVAILABLE = "PRODUCT_UNAVAILABLE";
	private static final String PRODUCT_FOUND = "PRODUCT_FOUND";
	private static final String SPACE = " ";
	private static final String CURRENCY = "Rs.";
	private static final String NO_MONEY_RECEIVED = "NO_MONEY_RECEIVED";
	private static final String INSUFFICIENT_MONEY_RECEIVED = "INSUFFICIENT_MONEY_RECEIVED";
	private static final String PURCHASE_SUCCESSFUL = "PURCHASE_SUCCESSFUL";
	private VendingService vendingService;
	private Inventory inventory;

	private List<Integer> getCoinsForValue10() {
		List<Integer> coins = new ArrayList<Integer>();
		coins.add(10);
		return coins;
	}

	private List<Integer> getCoinsForValue11() {
		List<Integer> coins = getCoinsForValue10();
		coins.add(1);
		return coins;
	}

	private Product getSampleProduct() {
		Product product = new Product("11", 11, 11);
		return product;
	}

	private void initializeInventory() {
		inventory = new Inventory();
		Product product = getSampleProduct();
		inventory.addProduct(product);
	}

	@Test
	public void setCoins_returnsErrorMessageForInsufficientMoneyReceived() {
		initializeInventory();
		vendingService = new VendingService(inventory);
		List<Integer> coins = getCoinsForValue10();
		vendingService.setProductCode("11");
		String message = vendingService.setCoins(coins);
		Assert.assertEquals(INSUFFICIENT_MONEY_RECEIVED, message);
	}

	@Test
	public void setCoins_returnsErrorMessageForNoMoneyReceived() {
		initializeInventory();
		vendingService = new VendingService(inventory);
		String message = vendingService.setCoins(null);
		Assert.assertEquals(NO_MONEY_RECEIVED, message);
	}

	@Test
	public void setCoins_returnsSuccessMessageForCorrectPurchase() {
		initializeInventory();
		vendingService = new VendingService(inventory);
		List<Integer> coins = getCoinsForValue11();
		vendingService.setProductCode("11");
		String message = vendingService.setCoins(coins);
		Assert.assertEquals(PURCHASE_SUCCESSFUL, message);
	}

	@Test
	public void setProductCode_returnsErrorMessageIfProductNotFound() {
		Inventory inventory = new Inventory();
		vendingService = new VendingService(inventory);
		String message = vendingService.setProductCode("11");
		Assert.assertEquals(PRODUCT_UNAVAILABLE, message);
	}

	@Test
	public void setProductCode_returnsErrorMessageIfProductQuantityIs0() {
		Inventory inventory = new Inventory();
		Product product = new Product("11", 11, 0);
		inventory.addProduct(product);
		vendingService = new VendingService(inventory);
		String message = vendingService.setProductCode("11");
		Assert.assertEquals(PRODUCT_UNAVAILABLE, message);
	}

	@Test
	public void setProductCode_returnsProductCostWhenProductFound() {
		initializeInventory();
		vendingService = new VendingService(inventory);
		String message = vendingService.setProductCode("11");
		Assert.assertEquals(PRODUCT_FOUND + SPACE + "11" + SPACE + 11
				+ CURRENCY, message);
	}

	@Test
	public void setProductCode_updatesInventoryWhenProductFound() {
		initializeInventory();
		vendingService = new VendingService(inventory);
		vendingService.setProductCode("11");
		vendingService.setCoins(getCoinsForValue11());
		Assert.assertEquals(1, inventory.getProducts().size());
		Assert.assertEquals(10, inventory.getProduct("11").getQuantity()
				.intValue());
	}

}
