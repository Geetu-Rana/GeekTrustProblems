package com.eCart.project.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long supplierId;
	@NotNull
	@Size(min = 3,max = 256, message = "Restaurant Name should contain more than 3 and less than 256 words")
	private String supplierName;
	
	@Embedded
	private Address address;
	
	
	
	
}
