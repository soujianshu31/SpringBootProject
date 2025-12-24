package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.City;
import com.test.repository.CityRepository;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityRepository repo;
	
	@PostMapping("/add")
	public City addCity(@RequestBody City city) {
		return repo.save(city);
	}
}
