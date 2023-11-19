package com.weather.demo.adapter.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocationDto {

	@JsonProperty("lat")
	private double latitude;
	
    @JsonProperty("lon")
    private double longitude;
	
}
