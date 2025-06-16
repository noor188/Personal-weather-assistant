package com.weather.Personal_weather_assistant.service;

import com.weather.Personal_weather_assistant.model.Location;
import com.weather.Personal_weather_assistant.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public Location getLocation(Integer id) {
        Location location = locationRepository.getLocationById(id);
        location.setTemperature(getTempAtLocation(location));
        return location;
    }

    public float getTempAtLocation(Location location){
        double lat = location.getLat();
        double lon = location.getLon();
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat +
                "&longitude=" + lon +
                "&current_weather=true";

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> body = response.getBody();
            Map<String, Object> currentWeather = (Map<String, Object>) body.get("current_weather");
            Object tempObj = currentWeather.get("temperature");
            float tempratue = ((Number) tempObj).floatValue();
            return tempratue;
        } else {
            return 0.0f;
        }

    }
}
