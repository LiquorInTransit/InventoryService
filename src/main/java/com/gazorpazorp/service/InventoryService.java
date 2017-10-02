package com.gazorpazorp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gazorpazorp.client.DeliveryClient;
import com.gazorpazorp.client.LCBOClient;
import com.gazorpazorp.model.Inventory;
import com.gazorpazorp.model.Quote;

@Service
public class InventoryService {
	Logger logger = LoggerFactory.getLogger(InventoryService.class);

	@Autowired
	LCBOClient lcboClient;
	@Autowired
	DeliveryClient deliveryClient;
	
	public List<Inventory> getInventoryForProductIds(String productIds, Long quoteId) {
		Quote quote = deliveryClient.getQuote(quoteId);
		
		Long storeId = quote.getStoreId();
		logger.info("STORE_ID: " + storeId);
		
		return Arrays.asList(productIds.split(",")).stream().map(prdId -> lcboClient.getInventory(storeId, prdId).getResult()).collect(Collectors.toList());
	}
	
}
