package com.pg.accommodation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pg.accommodation.dto.PgResponseDto;
import com.test.model.Owner;
import com.test.model.PGPlace;
import com.test.service.PGService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/pg")
public class PGController {

	@Autowired
	private PGService service;
	
	@GetMapping("/{cityId}")
	public List<PgResponseDto> getPGByCity(@PathVariable Long cityId) {
	    return service.getPGByCity(cityId);
	}
	
	@GetMapping("/locality/{name}")
	public List<PgResponseDto> getByLocality(@PathVariable String name){
		return service.getPGByLocality(name);
	}
	
	@GetMapping("/details/{id}")
	public PGPlace details(@PathVariable Long id) {
		return service.getPGDetails(id);
	}
	
	@GetMapping("/owner/{id}")
	public Owner owner(@PathVariable Long id) {
		return service.getOwnerDetails(id);
	}
	@PutMapping("/visit/{pgId}")
	public PGPlace increaseVisitorCount(@PathVariable Long pgId) {
	    return service.increaseVisitorCount(pgId);
	}
	@PostMapping("/owner/places/add")
	public String addPG(@RequestBody PGPlace pgPlace) {
	    service.addPGPlace(pgPlace);
	    return "pg added successfully";
	}
	@GetMapping("/owner/{ownerId}/places")
	public List<PGPlace> getPGsByOwner(@PathVariable Long ownerId) {
	    return service.getPGsByOwner(ownerId);
	}
	@PutMapping("/places/{id}/availability")
	public PGPlace updateAvailability(
	        @PathVariable Long id,
	        @RequestBody Map<String, String> body) {
	 
	    String availability = body.get("availability");
	    return service.updateAvailability(id, availability);
	}
	@Operation(
		    summary = "Edit PG place details",
		    description = "Updates rent, built-up area, and availability of a PG"
		)
	@PutMapping("/owner/places/edit/{placeId}")
	public PGPlace editPGPlace(
	        @PathVariable Long placeId,
	        @RequestBody PGPlace place) {
	 
	    return service.editPGPlace(placeId, place);
	}
	@Operation(
		    summary = "Delete PG place",
		    description = "Deletes a PG place permanently using PG ID"
		)
	@DeleteMapping("/owner/places/delete/{id}")
	public String deletePG(@PathVariable Long id) {
	    service.deletePGPlace(id);
	    return "PG place deleted successfully";
	}
	 
}
