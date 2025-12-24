package com.test.service;

import java.util.List;

import com.pg.accommodation.dto.PgResponseDto;
import com.test.model.Owner;
import com.test.model.PGPlace;

public interface PGService {

	List<PgResponseDto> getPGByCity(Long cityId);
	List<PgResponseDto> getPGByLocality(String locality);
	PGPlace getPGDetails(Long id);
	Owner getOwnerDetails(Long pgId);
	
	PGPlace increaseVisitorCount(Long pgId);
	PGPlace addPGPlace(PGPlace place);
	List<PGPlace> getPGsByOwner(Long ownerId);
	PGPlace updateAvailability(Long placeId, String availability);
	PGPlace editPGPlace(Long placeId,PGPlace updatedPlace);
	void deletePGPlace(Long placeId);
}
