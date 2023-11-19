package com.weather.demo.core.port;

import com.weather.demo.adapter.web.dto.CurrentWeatherDto;

public interface CurrentWeatherPort {

	CurrentWeatherDto getCurrentWeather(String city);

    CurrentWeatherDto getCurrentWeather(double latitude, double longitude);

}

