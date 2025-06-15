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

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{id}")
    public String getTempAtLocation(@PathVariable Integer id, Model model){
        Location location = locationService.getWeatherAtLocation(id);
        double lat = location.getLat();
        double lon = location.getLon();
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat +
                "&longitude=" + lon +
                "&current_weather=true";

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> body = response.getBody();
            Map<String, Object> currentWeather = (Map<String, Object>) body.get("current_weather");
            String temp = currentWeather.get("temperature") + "°C";
            model.addAttribute("temp", temp);
            return "";
        } else {
            String temp =  "Failed to fetch temperature.";
            model.addAttribute("temp", temp);
            return "";
        }

    }
}
