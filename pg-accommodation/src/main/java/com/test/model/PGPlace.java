package com.test.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pgplace")
public class PGPlace {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placeId;
	private String registrationNumber;
	private double builtUpArea;
	private double rent;
	private String availability;
	private Integer visitorCount;
	
	@ManyToOne
	private Owner owner;
	
	@ManyToOne
	private City city;
	
	@ManyToOne
	private Locality locality;

	public Long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public double getBuiltUpArea() {
		return builtUpArea;
	}

	public void setBuiltUpArea(double builtUpArea) {
		this.builtUpArea = builtUpArea;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability.name();
	}

	public Integer getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(Integer visitorCount) {
		this.visitorCount = visitorCount;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	
	
}
