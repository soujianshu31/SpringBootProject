package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.model.PGPlace;

@Repository
public interface PGPlaceRepository extends JpaRepository<PGPlace, Long> {
	
    List<PGPlace> findByCityCityIdAndAvailability(Long cityId, String availability);

    List<PGPlace> findByLocalityLocalityNameAndAvailability(String localityName, String availability);

  
    List<PGPlace> findByOwnerOwnerId(Long ownerId);
}
