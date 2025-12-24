package com.test.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="owner")
public class Owner {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ownerId;
	private String name;
	private String email;
	private String mobile;
	private int age;
	
	@OneToMany(mappedBy="owner")
	@JsonIgnore // to prevent infinite JSON recursion
	private  List<PGPlace> places;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<PGPlace> getPlaces() {
		return places;
	}

	public void setPlaces(List<PGPlace> places) {
		this.places = places;
	}

	public Owner() {
		
	}

	public Owner(Long ownerId, String name, String email, String mobile, int age, List<PGPlace> places) {
		super();
		this.ownerId = ownerId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.places = places;
	}
	
	
	
}
