package com.weather.demo.core.port;

import com.weather.demo.adapter.web.dto.WeatherForecastDto;

public interface ForecastPort {

	WeatherForecastDto getWeatherForecast(String city);

    WeatherForecastDto getWeatherForecast(double latitude, double longitude);

}