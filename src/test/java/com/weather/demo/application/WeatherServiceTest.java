package com.weather.demo.application;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.WeatherForecastDto;
import com.weather.demo.core.port.CurrentWeatherPort;
import com.weather.demo.core.port.ForecastPort;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

	@Mock
    private CurrentWeatherPort currentWeatherPort;

    @Mock
    private ForecastPort forecastPort;

    @InjectMocks
    private WeatherService weatherService;
    
    @Test
    void getCurrentWeatherByCity() {
      
    	String city = "Madrid";
        when(currentWeatherPort.getCurrentWeather(city)).thenReturn(mock(CurrentWeatherDto.class));

        CurrentWeatherDto result = weatherService.getCurrentWeather(city);

        assertNotNull(result);
        verify(currentWeatherPort, times(1)).getCurrentWeather(city);
    }
    
    @Test
    void getCurrentWeatherByCoordinates() {

    	double latitude = 123.45;
        double longitude = 67.89;
        when(currentWeatherPort.getCurrentWeather(latitude, longitude)).thenReturn(mock(CurrentWeatherDto.class));

        
        CurrentWeatherDto result = weatherService.getCurrentWeather(latitude, longitude);

        
        assertNotNull(result);
        verify(currentWeatherPort, times(1)).getCurrentWeather(latitude, longitude);
    }

    
    @Test
    void getWeatherForecastByCity() {

    	String city = "City1";
        when(forecastPort.getWeatherForecast(city)).thenReturn(mock(WeatherForecastDto.class));

        
        WeatherForecastDto result = weatherService.getWeatherForecast(city);

        assertNotNull(result);
        verify(forecastPort, times(1)).getWeatherForecast(city);
    }

    
    @Test
    void getWeatherForecastByCoordinates() {
    
    	double latitude = 123.45;
        double longitude = 67.89;
        when(forecastPort.getWeatherForecast(latitude, longitude)).thenReturn(mock(WeatherForecastDto.class));

        WeatherForecastDto result = weatherService.getWeatherForecast(latitude, longitude);

        assertNotNull(result);
        verify(forecastPort, times(1)).getWeatherForecast(latitude, longitude);
    }
}
