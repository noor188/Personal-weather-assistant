package com.weather.Personal_weather_assistant.controller;

import com.weather.Personal_weather_assistant.model.Location;
import com.weather.Personal_weather_assistant.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping("/location")
public class LocationController {
    //@PathVariable int id, Model model
    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public ResponseEntity<Location> getTempAtLocation(@PathVariable Integer id) {
        Location location = locationService.getLocation(id);
        return ResponseEntity.ok(location);
    }
}


