package com.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="locality")
public class Locality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long localityId;
	private String localityName;
	
	@ManyToOne(fetch=FetchType.EAGER)
	 private City city;

	public Long getLocalityId() {
		return localityId;
	}

	public void setLocalityId(Long localityId) {
		this.localityId = localityId;
	}

	public String getLocalityName() {
		return localityName;
	}

	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
