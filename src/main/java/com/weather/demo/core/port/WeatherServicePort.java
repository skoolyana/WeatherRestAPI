package com.weather.demo.core.port;

import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.WeatherForecastDto;

public interface WeatherServicePort {
	
	 CurrentWeatherDto getCurrentWeather(String city);
	 
	 CurrentWeatherDto getCurrentWeather(double latitude, double longitude);

	 WeatherForecastDto getWeatherForecast(String city);

	 WeatherForecastDto getWeatherForecast(double latitude, double longitude);
	
}
