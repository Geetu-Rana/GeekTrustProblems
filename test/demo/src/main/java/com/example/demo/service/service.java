package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Entries;
@Service
public class service {
	private final RestTemplate template;
	
	public service(RestTemplate temp) {
		// TODO Auto-generated constructor stub
		
		this.template=temp;
	}
	
	public Entries consumeApi() {
		return template.getForObject("https://api.publicapis.org/entries", Entries.class);
	}
	
}