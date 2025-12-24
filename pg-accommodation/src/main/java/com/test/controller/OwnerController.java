package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.City;
import com.test.model.Locality;
import com.test.model.Owner;
import com.test.model.PGPlace;
import com.test.repository.CityRepository;
import com.test.repository.LocalityRepository;
import com.test.repository.OwnerRepository;
import com.test.repository.PGPlaceRepository;
import com.test.service.OwnerService;

@RestController
@RequestMapping("/owner/places")
public class OwnerController {

	@Autowired
	private OwnerService service;
	@Autowired
	private OwnerRepository orepo;
	@Autowired
	private CityRepository crepo;
	@Autowired
	private LocalityRepository lrepo;
	@Autowired
	private PGPlaceRepository prepo;
	
	@PostMapping("/register")
	public Owner Register(@RequestBody Owner owner) {
		return service.registerOwner(owner);
	}
	@PostMapping("/add")
	public PGPlace addPlace(@RequestBody PGPlace place) {

	    Owner owner = orepo.findById(place.getOwner().getOwnerId())
	            .orElseThrow(() -> new RuntimeException("Owner not found"));

	    City city = crepo.findById(place.getCity().getCityId())
	            .orElseThrow(() -> new RuntimeException("City not found"));

	    Locality locality = lrepo.findById(place.getLocality().getLocalityId())
	            .orElseThrow(() -> new RuntimeException("Locality not found"));

	    place.setOwner(owner);
	    place.setCity(city);
	    place.setLocality(locality);

	    return prepo.save(place);
	}

	
	@GetMapping("/owner/{ownerId}")
	public List<PGPlace> list(@PathVariable("ownerId") Long ownerId) {
	    return service.getOwnerPlaces(ownerId);
	}

	@PutMapping("/{id}")
	public PGPlace updateStatus(@PathVariable Long id,@RequestParam String status) {
		return service.changeStatus(id, status);
	}
}
