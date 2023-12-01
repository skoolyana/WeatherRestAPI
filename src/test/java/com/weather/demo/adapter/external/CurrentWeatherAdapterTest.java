package com.weather.demo.adapter.external;

import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.GeoLocationDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrentWeatherAdapterTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CurrentWeatherAdapter currentWeatherAdapter;

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(currentWeatherAdapter, "geolocationApiUrl", "geolocationApiUrl");
        ReflectionTestUtils.setField(currentWeatherAdapter, "geolocationApiKey", "geolocationApiKey");
    }
    
    
    @SuppressWarnings("unchecked")
	@Test
    public void getCurrentWeather_Success() {
        // Arrange
        GeoLocationDto mockGeoLocation = GeoLocationDto.builder().latitude(123.456).longitude(789.012).build();
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class)
        )).thenReturn(ResponseEntity.ok(Collections.singletonList(mockGeoLocation)));

        // Mock the behavior of getCurrentWeather(double latitude, double longitude)
        when(restTemplate.getForObject(anyString(), eq(CurrentWeatherDto.class))).thenReturn(new CurrentWeatherDto());

        // Act
        CurrentWeatherDto result = currentWeatherAdapter.getCurrentWeather("City1");

        // Assert
        assertNotNull(result);
    }

    @SuppressWarnings("unchecked")
	@Test
    public void getCurrentWeather_EmptyResponse() {
        // Arrange
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                eq(null),
                any(ParameterizedTypeReference.class)
        )).thenReturn(ResponseEntity.ok(Collections.emptyList()));

        // Act
        CurrentWeatherDto result = currentWeatherAdapter.getCurrentWeather("City2");

        // Assert
        assertNull(result);
    }   
}
