package com.weather.demo.application;

import org.springframework.stereotype.Service;
import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.WeatherForecastDto;
import com.weather.demo.core.port.CurrentWeatherPort;
import com.weather.demo.core.port.ForecastPort;
import com.weather.demo.core.port.WeatherServicePort;

@Service
public class WeatherService implements WeatherServicePort{

	private final CurrentWeatherPort currentWeatherPort;
	
	private final ForecastPort forecastPort;
		

	public WeatherService(CurrentWeatherPort currentWeatherPort,ForecastPort forecastPort) {
		this.currentWeatherPort = currentWeatherPort;
		this.forecastPort = forecastPort;
		
	}

	@Override
	public CurrentWeatherDto getCurrentWeather(String city) {

		return currentWeatherPort.getCurrentWeather(city);
	}

	@Override
	public CurrentWeatherDto getCurrentWeather(double latitude, double longitude) {

		return currentWeatherPort.getCurrentWeather(latitude, longitude);
	}

	@Override
	public WeatherForecastDto getWeatherForecast(String city) {
		
		try {
	        
	        return forecastPort.getWeatherForecast(city);
	    } catch (Exception e) {
	        e.printStackTrace();	       
	        return null; 
	    }
	}

	@Override
	public WeatherForecastDto getWeatherForecast(double latitude, double longitude) {
		
		try {	        
	        return forecastPort.getWeatherForecast(latitude, longitude);
	    } catch (Exception e) {
	        e.printStackTrace();	       
	        return null; 
	    }
				
	}
}
