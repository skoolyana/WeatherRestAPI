package com.weather.demo.adapter.external;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import com.weather.demo.adapter.web.dto.WeatherForecastDto;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastAdapterTest {
	
	   @Mock
	   private RestTemplate restTemplate;

	   @InjectMocks
	   private WeatherForecastAdapter weatherForecastAdapter;

	   
	    @Test
	    public void getWeatherForecast_Success() {
	        WeatherForecastDto mockWeatherForecast = new WeatherForecastDto();
	        when(restTemplate.getForObject(anyString(), eq(WeatherForecastDto.class)))
	                .thenReturn(mockWeatherForecast);

	        WeatherForecastDto result = weatherForecastAdapter.getWeatherForecast("City1");

	        assertNotNull(result);
	    }
	   
	    @Test
	    public void getWeatherForecast_EmptyResponse() {

		   	when(restTemplate.getForObject(anyString(), eq(WeatherForecastDto.class)))
	                .thenReturn(null);

	        WeatherForecastDto result = weatherForecastAdapter.getWeatherForecast("City2");

	        assertNull(result);
	    }
	    
	    @Test
	    public void getWeatherForecastByLatLon_Success() {

	    	WeatherForecastDto mockWeatherForecast = new WeatherForecastDto();
	        when(restTemplate.getForObject(anyString(), eq(WeatherForecastDto.class)))
	                .thenReturn(mockWeatherForecast);

	        
	        WeatherForecastDto result = weatherForecastAdapter.getWeatherForecast(12.34, 56.78);

	        
	        assertNotNull(result);
	    }

	    @Test
	    public void getWeatherForecastByLatLon_EmptyResponse() {
	        
	    	
	        when(restTemplate.getForObject(anyString(), eq(WeatherForecastDto.class)))
	                .thenReturn(null);

	        
	        WeatherForecastDto result = weatherForecastAdapter.getWeatherForecast(90.0, 180.0);

	        
	        assertNull(result);
	    }
}
