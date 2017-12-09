package com.gazorpazorp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryResult {
	public InventoryResult() {}
	public InventoryResult(Inventory result) {
		this.result = result;
	}
	
	@JsonProperty("result")
	public Inventory result;

	public Inventory getResult() {
		return result;
	}

	public void setResult(Inventory result) {
		this.result = result;
	}
	
	
}
