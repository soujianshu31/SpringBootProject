package com.test.service;

import java.util.List;

import com.test.model.Owner;
import com.test.model.PGPlace;

public interface OwnerService {

	PGPlace addPlace(PGPlace place);
	List<PGPlace> getOwnerPlaces(Long ownerId);
	PGPlace changeStatus(Long placeId,String status);
	Owner registerOwner(Owner owner);
}
