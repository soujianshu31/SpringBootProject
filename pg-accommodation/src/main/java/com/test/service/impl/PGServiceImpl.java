package com.test.service.impl;

import java.util.ArrayList;
import com.test.model.Availability;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.accommodation.dto.PgResponseDto;
import com.test.model.City;
import com.test.model.Locality;
import com.test.model.Owner;
import com.test.model.PGPlace;
import com.test.repository.CityRepository;
import com.test.repository.LocalityRepository;
import com.test.repository.OwnerRepository;
import com.test.repository.PGPlaceRepository;
import com.test.service.PGService;

@Service
public class PGServiceImpl implements PGService {

	@Autowired
	private PGPlaceRepository repo;
	@Autowired private PGPlaceRepository pgRepo;
	@Autowired private OwnerRepository ownerRepo;
	@Autowired private CityRepository cityRepo;
	@Autowired private LocalityRepository localityRepo;
	 
	
	@Override
	public List<PgResponseDto> getPGByCity(Long cityId) {
	 
	    List<PGPlace> pgList =
	            repo.findByCityCityIdAndAvailability(cityId, "AVAILABLE");
	 
	    List<PgResponseDto> dtoList = new ArrayList<>();
	 
	    for (PGPlace pg : pgList) {
	 
	        PgResponseDto dto = new PgResponseDto();
	 
	        dto.setPlaceId(pg.getPlaceId());
	        dto.setRegistrationNumber(pg.getRegistrationNumber());
	        dto.setRent(pg.getRent());
	        dto.setAvailability(pg.getAvailability().toString());
	        dto.setCityName(pg.getCity().getCityName());
	        dto.setLocalityName(pg.getLocality().getLocalityName());
	 
	        dtoList.add(dto);
	    }
	 
	    return dtoList;
	}
	@Override
	public PGPlace increaseVisitorCount(Long pgId) {
	 
	    PGPlace place = repo.findById(pgId)
	            .orElseThrow(() -> new RuntimeException("Invalid PG Id"));
	 
	    place.setVisitorCount(place.getVisitorCount() + 1);
	 return repo.save(place);
	}
	@Override
	public List<PgResponseDto> getPGByLocality(String locality) {
	 
	    List<PGPlace> pgList =
	            repo.findByLocalityLocalityNameAndAvailability(locality, "AVAILABLE");
	 
	    List<PgResponseDto> dtoList = new ArrayList<>();
	 
	    for (PGPlace pg : pgList) {
	        PgResponseDto dto = new PgResponseDto();
	 
	        dto.setPlaceId(pg.getPlaceId());
	        dto.setRegistrationNumber(pg.getRegistrationNumber());
	        dto.setRent(pg.getRent());
	        dto.setAvailability(pg.getAvailability().toString());
	        dto.setCityName(pg.getCity().getCityName());
	        dto.setLocalityName(pg.getLocality().getLocalityName());
	 
	        dtoList.add(dto);
	    }
	 
	    return dtoList;
	}

	@Override
	public PGPlace getPGDetails(Long id) {
		PGPlace place =repo.findById(id)
				.orElseThrow(()->new RuntimeException("Invalid Pg Id"));
		place.setVisitorCount(place.getVisitorCount()+1);
		return repo.save(place);
	}

	@Override
	public Owner getOwnerDetails(Long pgId) {
		PGPlace place =repo.findById(pgId)
				.orElseThrow(()->new RuntimeException("Invalid Pg Id"));
		return place.getOwner();
	}
	@Override
	public PGPlace addPGPlace(PGPlace place) {
	 
	    Owner owner = ownerRepo.findById(place.getOwner().getOwnerId())
	            .orElseThrow(() -> new RuntimeException("Owner not found"));
	 
	    City city = cityRepo.findById(place.getCity().getCityId())
	            .orElseThrow(() -> new RuntimeException("City not found"));
	 
	    Locality locality = localityRepo.findById(place.getLocality().getLocalityId())
	            .orElseThrow(() -> new RuntimeException("Locality not found"));
	 
	    place.setOwner(owner);
	    place.setCity(city);
	    place.setLocality(locality);
	 
	    place.setVisitorCount(0); // safety
	 
	    return pgRepo.save(place);  
	}
	@Override
	public List<PGPlace> getPGsByOwner(Long ownerId) {
	    return repo.findByOwnerOwnerId(ownerId);
	}
	 
	@Override
	public PGPlace updateAvailability(Long placeId, String availability) {
	 
	    PGPlace place = pgRepo.findById(placeId)
	            .orElseThrow(() -> new RuntimeException("PG not found"));
	 
	    place.setAvailability(Availability.valueOf(availability));
	    return pgRepo.save(place);
	}
	
	@Override
	public PGPlace editPGPlace(Long placeId, PGPlace updatedPlace) {
	 
	    PGPlace existingPlace = pgRepo.findById(placeId)
	            .orElseThrow(() -> new RuntimeException("PG not found"));
	 
	    // update allowed fields only
	    existingPlace.setRent(updatedPlace.getRent());
	    existingPlace.setBuiltUpArea(updatedPlace.getBuiltUpArea());
	 
	    if (updatedPlace.getAvailability() != null) {
	        existingPlace.setAvailability(
	                Availability.valueOf(updatedPlace.getAvailability())
	        );
	    }
	 
	    return pgRepo.save(existingPlace);
	}
	@Override
	public void deletePGPlace(Long placeId) {
	    pgRepo.deleteById(placeId);
	}
}
