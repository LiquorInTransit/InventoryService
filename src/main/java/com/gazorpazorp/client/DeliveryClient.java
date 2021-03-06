package com.gazorpazorp.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gazorpazorp.client.config.TokenRequestClientConfiguration;
import com.gazorpazorp.model.Quote;

@FeignClient(name = "order-and-delivery-service", configuration = TokenRequestClientConfiguration.class)
public interface DeliveryClient {

	@GetMapping("/internal/deliveries/quote/{id}")
	public Quote getQuote(@PathVariable("id") Long id);
}
