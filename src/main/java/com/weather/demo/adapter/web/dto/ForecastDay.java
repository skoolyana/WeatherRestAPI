package com.weather.demo.adapter.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForecastDay {
	
	 private String date;
     private Day day;
     private Astro astro;

}
