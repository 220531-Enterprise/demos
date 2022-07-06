package com.revature.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * What is a DTO? Data Transfer Object Design Pattern
 * 
 * DTOs can either contain all the data from a source, or partial data. They can
 * hold data from single or multiple sources as well. When implemented, DTOs
 * become the means of data transport between systems.
 */
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Credentials { // use in our controller layer

	@NotNull
	@NotBlank
	@Length(min=2)
	private String username;
	
	@NotNull
	@NotBlank
	private String password;

}
