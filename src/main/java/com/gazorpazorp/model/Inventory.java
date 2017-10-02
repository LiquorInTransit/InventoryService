package com.gazorpazorp.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Inventory {
	
	@JsonAlias("product_id")
	private Long productId;
	@JsonAlias("quantity")
	private Integer count;
	
	public Inventory() {}

	@JsonAlias("product_id")
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@JsonAlias("quantity")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}	
}
