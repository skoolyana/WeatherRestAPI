package com.weather.demo.adapter.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.WeatherForecastDto;
import com.weather.demo.application.WeatherService;

//WeatherController.java
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

 private final WeatherService weatherService;

 public WeatherController(WeatherService weatherService) {
     this.weatherService = weatherService;
 }

 @GetMapping("/current")
 public ResponseEntity<CurrentWeatherDto> getCurrentWeather(@RequestParam(required = false) String city,
                                                           @RequestParam(required = false) Double lat,
                                                           @RequestParam(required = false) Double lon) {
     CurrentWeatherDto currentWeather;
  
     if (city != null) {
         currentWeather = weatherService.getCurrentWeather(city);
     } else if (lat != null && lon != null) {
         currentWeather = weatherService.getCurrentWeather(lat, lon);
     } else {
         return ResponseEntity.badRequest().build();
     }

     return ResponseEntity.ok(currentWeather);
 }

 @GetMapping("/forecast")
 public ResponseEntity<WeatherForecastDto> getWeatherForecast(@RequestParam(required = false) String city,
                                                      @RequestParam(required = false) Double lat,
                                                      @RequestParam(required = false) Double lon) {
	 WeatherForecastDto forecast;
     if (city != null) {
         forecast = weatherService.getWeatherForecast(city);
     } else if (lat != null && lon != null) {
         forecast = weatherService.getWeatherForecast(lat, lon);
     } else {
         return ResponseEntity.badRequest().build();
     }

     return ResponseEntity.ok(forecast);
 }
 
}
