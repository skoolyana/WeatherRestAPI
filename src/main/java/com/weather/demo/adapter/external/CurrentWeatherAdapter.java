package com.weather.demo.adapter.external;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.GeoLocationDto;
import com.weather.demo.core.port.CurrentWeatherPort;

@Service
public class CurrentWeatherAdapter implements CurrentWeatherPort {

	private final RestTemplate restTemplate;
    private final String weatherApiKey;
    private final String weatherApiUrl;
    private final String geolocationApiKey; 
    private final String geolocationApiUrl;

    public CurrentWeatherAdapter(RestTemplate restTemplate,
                                @Value("${openweathermap.api.key}") String weatherApiKey,
                                @Value("${openweathermap.api.url}") String weatherApiUrl,
                                @Value("${geolocation.api.key}") String geolocationApiKey, 
                                @Value("${geolocation.api.url}") String geolocationApiUrl) { 
        this.restTemplate = restTemplate;
        this.weatherApiKey = weatherApiKey;
        this.weatherApiUrl = weatherApiUrl;
        this.geolocationApiKey = geolocationApiKey; 
        this.geolocationApiUrl = geolocationApiUrl; 
    }


    @Override
    public CurrentWeatherDto getCurrentWeather(String city) {
        GeoLocationDto geoLocation = getGeoLocation(city);
        if (geoLocation != null) {
            return getCurrentWeather(geoLocation.getLatitude(), geoLocation.getLongitude());
        }
        return null;
    }

    @Override
    public CurrentWeatherDto getCurrentWeather(double latitude, double longitude) {
        String url = weatherApiUrl + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + weatherApiKey;
        return restTemplate.getForObject(url, CurrentWeatherDto.class);
    }

    private GeoLocationDto getGeoLocation(String city) {
        String url = geolocationApiUrl + "?q=" + city + "&limit=1&appid=" + geolocationApiKey;

        try {
            ResponseEntity<List<GeoLocationDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GeoLocationDto>>() {}
            );

            return responseEntity.getBody().stream().findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
