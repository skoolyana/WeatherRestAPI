package com.weather.demo.adapter.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.demo.adapter.web.dto.WeatherForecastDto;
import com.weather.demo.core.port.ForecastPort;

@Service
public class WeatherForecastAdapter implements ForecastPort {

	 private final RestTemplate restTemplate;
	 private final String forecastApiKey;
	 private final String forecastApiUrl;

	
    public WeatherForecastAdapter(RestTemplate restTemplate,
                                  @Value("${forecast.api.key}") String forecastApiKey,
                                  @Value("${forecast.api.url}") String forecastApiUrl) {
        this.restTemplate = restTemplate;
        this.forecastApiKey = forecastApiKey;
        this.forecastApiUrl = forecastApiUrl;
    }

    @Override
    public WeatherForecastDto getWeatherForecast(String city) {
        String url = forecastApiUrl + "?q=" + city + "&days=3&key=" + forecastApiKey;
        return restTemplate.getForObject(url, WeatherForecastDto.class);
    }

    @Override
    public WeatherForecastDto getWeatherForecast(double latitude, double longitude) {
        String url = forecastApiUrl + "?q=" + latitude + "," + longitude + "&days=3&key=" + forecastApiKey;
        return restTemplate.getForObject(url, WeatherForecastDto.class);
    }

}
