package com.weather.Personal_weather_assistant.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Enumerated(EnumType.STRING)
    private LocationName locationName;
    private Long temperature;
    private double lon;
    private double lat;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LocationName getLocationName() {
        return locationName;
    }

    public void setLocationName(LocationName locationName) {
        this.locationName = locationName;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
