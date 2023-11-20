package com.weather.demo.adapter.web;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.weather.demo.adapter.web.dto.Astro;
import com.weather.demo.adapter.web.dto.Coord;
import com.weather.demo.adapter.web.dto.CurrentWeatherDto;
import com.weather.demo.adapter.web.dto.Day;
import com.weather.demo.adapter.web.dto.Forecast;
import com.weather.demo.adapter.web.dto.ForecastDay;
import com.weather.demo.adapter.web.dto.WeatherForecastDto;
import com.weather.demo.application.WeatherService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private WeatherService weatherService;
	
	@Test
    public void getCurrentWeather_Success() throws Exception {
        
		CurrentWeatherDto mockCurrentWeather = CurrentWeatherDto.builder()
			    .coord(Coord.builder()
			        .lon(10.0)
			        .lat(20.0)
			        .build())
			    .build();
        when(weatherService.getCurrentWeather("City1")).thenReturn(mockCurrentWeather);
       
        mockMvc.perform(MockMvcRequestBuilders.get("/api/weather/current?city=City1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.coord").exists());
    }
	
	@Test
    public void getWeatherForecast_Success() throws Exception {
		
	    WeatherForecastDto mockWeatherForecast = WeatherForecastDto.builder()
	            .forecast(Forecast.builder()
	                    .forecastday(Arrays.asList(
	                            ForecastDay.builder()
	                                    .date("2023-11-20")
	                                    .day(Day.builder()
	                                            .maxTempC(25.0)
	                                            .minTempC(15.0)
	                                            .build())
	                                    .astro(Astro.builder()
	                                            .sunrise("06:00")
	                                            .sunset("18:00")
	                                            .build())
	                                    .build()
	                    ))
	                    .build())
	            .build();
        
        when(weatherService.getWeatherForecast("City1")).thenReturn(mockWeatherForecast);

        
        mockMvc.perform(MockMvcRequestBuilders.get("/api/weather/forecast?city=City1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.forecast").exists());
    }
}
