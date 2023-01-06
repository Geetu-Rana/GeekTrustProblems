package com.eCart.project.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.eCart.project.model.enums.Gender;
import com.eCart.project.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	
	@NotNull(message = "Name can not be null")
	@NotBlank(message = " Name can not be Blank")
	@Length(min =3, max= 30 ,message = "name should be greater 3 character and less than 30 character")
	private String customerFirstName;
	
	@Length(min =3, max= 30 ,message = "name should be greater 3 character and less than 30 character")
	private String customerLastName;
	
	@Range(min = 10, max = 100, message = "age sholud be in the range of 10 to 100")
	private Integer Age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private Role role;
	
	private final LocalDateTime date_created = LocalDateTime.now();
	
	@ElementCollection
	private Set<Address> address;

	@Pattern(regexp = "")
	private String password;
}
