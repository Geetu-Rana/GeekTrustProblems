package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data

public class Data {

	@JsonProperty("API")
	private String api;
	
    @JsonProperty("Description")
	private String description;
    
    @JsonProperty("Auth")
    private String auth;
    
    @JsonProperty("HTTPS")
    private Boolean https;
    
    @JsonProperty("Cors")
    private String cors;
    
    @JsonProperty("Link")
    private String link;
    
    @JsonProperty("Category")
    private String category;
  
    
    
}
