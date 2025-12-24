package com.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.model.Owner;
import com.test.model.PGPlace;
import com.test.repository.OwnerRepository;
import com.test.repository.PGPlaceRepository;
import com.test.service.OwnerService;
import com.test.model.Availability;

@Service
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	private PGPlaceRepository repo;
	@Autowired
	private OwnerRepository orepo;

	@Override
	public PGPlace addPlace(PGPlace place) {
		place.setAvailability(Availability.AVAILABLE);
		place.setVisitorCount(0);
		return repo.save(place);
	}

	@Override
	public List<PGPlace> getOwnerPlaces(Long ownerId) {
		return repo.findByOwnerOwnerId(ownerId);
	}

	@Override
	public PGPlace changeStatus(Long placeId, String status) {
		PGPlace place=repo.findById(placeId)
		            .orElseThrow(() -> new RuntimeException("PG not found"));
		place.setAvailability(Availability.valueOf(status));
		return repo.save(place);
		
		
	}

	@Override
	public Owner registerOwner(Owner owner) {
          if(owner.getAge()<18) {
        	  throw new RuntimeException("Owner must be atleast 18 Years old");
          }
		return orepo.save(owner);
	}

}
