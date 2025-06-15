package com.weather.Personal_weather_assistant.service;

import com.weather.Personal_weather_assistant.model.Location;
import com.weather.Personal_weather_assistant.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location getWeatherAtLocation(Integer id) {
        return locationRepository.getLocationById(id);
    }
}
