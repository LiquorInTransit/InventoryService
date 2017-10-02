package com.gazorpazorp.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gazorpazorp.model.InventoryResult;

import feign.Headers;

@FeignClient(name="lcbo-client") //Name can be custom name defined in bootstrap.yml, or the name of a service registered with eureka
public interface LCBOClient {
	
	@GetMapping(value="/stores/{storeId}/products/{productId}/inventory", consumes = "application/json")
	@Headers(value = { "Authorization: Token ${lcbo-client.key}", "Content-Type: application/json"})
	InventoryResult getInventory(@PathVariable("storeId") Long storeId, @PathVariable("productId") String productId);
}

