package com.gazorpazorp.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonRootName;

public class Quote {
	private Long id;
	private Long customerId;

	private Pickup pickup;
	
	public Quote() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
//	public Long getStoreId() {
//		return storeId;
//	}
//	public void setStoreId(Long storeId) {
//		this.storeId = storeId;
//	}
	public Pickup getPickup() {
		return pickup;
	}
	public void setPickup(Pickup pickup) {
		this.pickup = pickup;
	}
	


	@Override
	public String toString() {
		return "Quote [id=" + id + ", customerId=" + customerId + "]";
	}



	
	
}
