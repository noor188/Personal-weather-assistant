package com.weather.Personal_weather_assistant.repository;

import com.weather.Personal_weather_assistant.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location getLocationById(Integer id);
}
