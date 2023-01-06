package com.eCart.project.responseModel;

import com.eCart.project.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResponseUser {
	
	private String userFirstName;
	
	private String userLastName;
	
	private String gender;
	
	private Integer age;
	
	private Address address;
	
	private String role;
}
