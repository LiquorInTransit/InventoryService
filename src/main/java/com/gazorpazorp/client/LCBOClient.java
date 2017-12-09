package com.gazorpazorp.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gazorpazorp.model.Inventory;
import com.gazorpazorp.model.InventoryResult;

import feign.Headers;
import feign.hystrix.FallbackFactory;

@FeignClient(name="lcbo-client", fallbackFactory=LCBOClientFallback.class) //Name can be custom name defined in bootstrap.yml, or the name of a service registered with eureka
public interface LCBOClient {
	
	@GetMapping(value="/stores/{storeId}/products/{productId}/inventory", consumes = "application/json")
	@Headers(value = { "Authorization: Token ${lcbo-client.key}", "Content-Type: application/json"})
	InventoryResult getInventory(@PathVariable("storeId") Long storeId, @PathVariable("productId") String productId);
}

@Component
class LCBOClientFallback implements FallbackFactory<LCBOClient> {
	Logger logger = LoggerFactory.getLogger(LCBOClient.class);
	
	
	@Override
	public LCBOClient create(Throwable arg0) {
		return (Long storeId, String productId) -> {
				logger.error("Feign error executing " + arg0.getMessage());
				Inventory inv = new Inventory();
				inv.setProductId(Long.parseLong(productId));
				inv.setCount(-1);
				return new InventoryResult(inv);
			};
	}	
}
