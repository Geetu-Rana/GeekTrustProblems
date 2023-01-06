package com.eCart.project.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
	
	private Integer addressID;
	
	private String buildingName;
	
	private String StreetNo;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	@Size(min = 6,max = 6)
	private String pincode;
	@NotNull
	private String type;

	@Email(message = "Enter email in example@email.com")
	@NotNull
	private String email;
	
	@NotNull
	private String phoneNumber;
	
}
