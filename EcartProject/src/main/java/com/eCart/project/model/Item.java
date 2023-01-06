package com.eCart.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	
	private String ItemName;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
	
	@NotNull(message = "brand can not be null")
	private String brand;
	
	private String sub_category;
	
	@NotNull
	private Double salePrice;
	@NotNull
	private Double MarketPrice;
	
	private String type;
	
}
