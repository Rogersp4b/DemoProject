package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "DemoService", url = "https://api.coindesk.com/v1/bpi")
public interface DemoFeignService {

	// 取得coindesk API的json
	@GetMapping(path = "/currentprice.json", consumes = "application/javascript")
	String getPosts();

}