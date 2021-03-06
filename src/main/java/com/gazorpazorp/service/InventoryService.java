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
		if (quote == null || quote.getPickup().getStore()==null)
			return null;
		
		Long storeId = quote.getPickup().getStore().getId();
		
		return Arrays.asList(productIds.split(","))
				.stream()
				.map(prdId -> {logger.info("Making inventory request to: /stores/"+storeId+"/products/"+prdId+"/inventory");
								return lcboClient.getInventory(storeId, prdId).getResult();}).collect(Collectors.toList());
	}	
}
