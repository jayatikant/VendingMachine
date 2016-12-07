package com.sample.model;

public class Product {

	private String code;
	private Integer cost;
	private Integer quantity;
	
	public Product(String code, Integer cost, Integer quantity) {
		super();
		this.code = code;
		this.cost = cost;
		this.quantity = quantity;
	}

	public Product(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public Integer getCost() {
		return cost;
	}

	public Integer getQuantity() {
		return quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || !(obj instanceof Product)) {
			return false;
		}
		Product productToCompare = (Product) obj;
		return productToCompare.code == this.code
				|| (productToCompare.code != null && productToCompare.code
						.equals(this.code));
	}

	@Override
	public int hashCode() {
		int result = 31 + ((code == null) ? 0 : code.hashCode());
		return result;
	}
}
