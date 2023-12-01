package com.weather.demo.core.port;

import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.WeatherForecastDto;
import com.weather.demo.core.exception.WeatherServiceException;

public interface WeatherServicePort {
	
	 CurrentWeatherDto getCurrentWeather(String city) throws WeatherServiceException;
	 
	 CurrentWeatherDto getCurrentWeather(double latitude, double longitude) throws WeatherServiceException;

	 WeatherForecastDto getWeatherForecast(String city) throws WeatherServiceException;

	 WeatherForecastDto getWeatherForecast(double latitude, double longitude) throws WeatherServiceException;
	
}
