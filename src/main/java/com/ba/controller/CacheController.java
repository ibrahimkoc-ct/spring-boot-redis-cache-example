package com.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ba.service.CacheService;

@RestController
@RequestMapping("/cache")
public class CacheController {
	
	private int count=0;
	
	@Autowired
	private CacheService service;
	
	@GetMapping
	public String cacheControl() throws InterruptedException {
		if(count==5) {
			service.clearCache();
			count=0;
		}
		count++;
		return service.longRunningMethod();
	}

}
