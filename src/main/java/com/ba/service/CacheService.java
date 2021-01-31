package com.ba.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
	
	int count=0;
	
	@Cacheable(cacheNames = "mySpecialCache")
	public String longRunningMethod() throws InterruptedException {
		Thread.sleep(5000L);
		return "Method calisiyor";
	}
	
	@CacheEvict(cacheNames = "mySpecialCache")
	public void clearCache() {
		System.out.println("Cache clear");
	}

}
