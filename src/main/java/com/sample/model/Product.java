package com.sample.model;

public class Product {
	
	private static final Product EMPTY_PRODUCT=new Product();
	private String code;
	private Integer cost;
	private Integer quantity;

	public Product() {
	}
	
	public Product(String code, Integer cost, Integer quantity) {
		super();
		this.code = code;
		this.cost = cost;
		this.setQuantity(quantity);
	}
	
	public static Product  getEmptyProduct(){
		return EMPTY_PRODUCT;
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

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
