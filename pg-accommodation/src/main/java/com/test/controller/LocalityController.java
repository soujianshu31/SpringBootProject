package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.City;
import com.test.model.Locality;
import com.test.repository.CityRepository;
import com.test.repository.LocalityRepository;

@RestController
@RequestMapping("/locality")
public class LocalityController {

    @Autowired
    private LocalityRepository localityRepo;

    @Autowired
    private CityRepository cityRepo;

    @PostMapping("/add")
    public Locality addLocality(@RequestBody Locality locality) {

        Long cityId = locality.getCity().getCityId();

       
        City city = cityRepo.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found with id " + cityId));

      
        locality.setCity(city);

     
        return localityRepo.save(locality);
    }
}
