package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * JPA is a specification (the art) 
 * 
 * Hibernate is the implementation (the artist)
 *
 */
@Entity // import from javax.persistence -- JPA
@Table(name="crimes") // Table differs from Entity in that it alllwos to deifne extra
public class Crime {
	
	@Id // ID annotation means Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // SERIAL
	private int crimeId; // we want this SERIAL and auto-generated
	
	@Column(unique=true, nullable=false) // we only use the Column attribute when we add extra info like constraints
	private String crimeName; // varchar
	
	// this column will still be created but with NO OTHER CONSTRAINTS (it will be nullable, and non-unique)
	@Column(length=250)
	private String description; 
	
	
	
	// no args constructor (mandatory by Hibernates standards)
	public Crime() {
		super();
	}

	// constructor with no ID
	public Crime(String crimeName, String description) {
		super();
		this.crimeName = crimeName;
		this.description = description;
	}
	
	public Crime(int crimeId, String crimeName, String description) {
		super();
		this.crimeId = crimeId;
		this.crimeName = crimeName;
		this.description = description;
	}

	// getters & setters
	public int getCrimeId() {
		return crimeId;
	}

	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}

	public String getCrimeName() {
		return crimeName;
	}

	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// hashCode & equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + crimeId;
		result = prime * result + ((crimeName == null) ? 0 : crimeName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crime other = (Crime) obj;
		if (crimeId != other.crimeId)
			return false;
		if (crimeName == null) {
			if (other.crimeName != null)
				return false;
		} else if (!crimeName.equals(other.crimeName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Crime [crimeId=" + crimeId + ", crimeName=" + crimeName + ", description=" + description + "]";
	}

}
