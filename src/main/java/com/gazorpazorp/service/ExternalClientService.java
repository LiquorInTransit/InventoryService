package com.gazorpazorp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gazorpazorp.client.LCBOClient;
import com.gazorpazorp.model.Inventory;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ExternalClientService {
	
	@Autowired
	LCBOClient lcboClient;

	@HystrixCommand(fallbackMethod="getInventoryFallback")
	public Inventory getInventory (Long storeId, String prdId) {
		return lcboClient.getInventory(storeId, prdId).getResult();
	}
	
	public Inventory getInventoryFallback (Long storeId, String prdId) {
		Inventory inv = new Inventory();
		inv.setProductId(Long.parseLong(prdId));
		inv.setCount(-1);
		return inv;
	}
}
