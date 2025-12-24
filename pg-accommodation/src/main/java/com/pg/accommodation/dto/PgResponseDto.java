package com.pg.accommodation.dto;
	 
	public class PgResponseDto {
	 
	    private Long placeId;
	    private String registrationNumber;
	    private Double rent;
	    private String availability;
	    private String localityName;
	    private String cityName;
	 
	    // Getters and Setters
	    public Long getPlaceId() {
	        return placeId;
	    }
	 
	    public void setPlaceId(Long placeId) {
	        this.placeId = placeId;
	    }
	 
	    public String getRegistrationNumber() {
	        return registrationNumber;
	    }
	 
	    public void setRegistrationNumber(String registrationNumber) {
	        this.registrationNumber = registrationNumber;
	    }
	 
	    public Double getRent() {
	        return rent;
	    }
	 
	    public void setRent(Double rent) {
	        this.rent = rent;
	    }
	 
	    public String getAvailability() {
	        return availability;
	    }
	 
	    public void setAvailability(String availability) {
	        this.availability = availability;
	    }
	 
	    public String getLocalityName() {
	        return localityName;
	    }
	 
	    public void setLocalityName(String localityName) {
	        this.localityName = localityName;
	    }
	 
	    public String getCityName() {
	        return cityName;
	    }
	 
	    public void setCityName(String cityName) {
	        this.cityName = cityName;
	    }
	}
	 

