package com.revature.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;


@Entity
@Table(name="addresses")
@Data @AllArgsConstructor @NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@EqualsAndHashCode(exclude={"owners"}) @ToString(exclude= {"owners"}) // prevents Hibernate from causing infinite loop
public class Address {
	
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String street; // 32 Main St.
	private String secondary; // Apt.B
	
	@Length(min=2, max=2)
	private String state;// NJ
	
	private String city; // Trenton
	private String zip; // 22112-223
	
	// declare the porety of the owner of the realation ship that this is mapped to
	@ManyToMany(mappedBy="addresses")
	private @NonNull Set<User> owners; // list of all users who are registered at this address 

	// constructor with no ID and no owners set
	public Address(String street, String secondary, @Length(min = 2, max = 2) String state, String city, String zip) {
		super();
		this.street = street;
		this.secondary = secondary;
		this.state = state;
		this.city = city;
		this.zip = zip;
	}
}
