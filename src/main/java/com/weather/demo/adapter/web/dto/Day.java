package com.weather.demo.adapter.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Day {
	
	@JsonProperty("maxtemp_c")
    private double maxTempC;

    @JsonProperty("maxtemp_f")
    private double maxTempF;

    @JsonProperty("mintemp_c")
    private double minTempC;

    @JsonProperty("mintemp_f")
    private double minTempF;

    @JsonProperty("avgtemp_c")
    private double avgTempC;

    @JsonProperty("avgtemp_f")
    private double avgTempF;

    @JsonProperty("maxwind_mph")
    private double maxWindMph;

    @JsonProperty("maxwind_kph")
    private double maxWindKph;

    @JsonProperty("totalprecip_mm")
    private double totalPrecipMM;

    @JsonProperty("totalprecip_in")
    private double totalPrecipIn;

    @JsonProperty("totalsnow_cm")
    private double totalSnowCM;

    @JsonProperty("avgvis_km")
    private double avgVisKM;

    @JsonProperty("avgvis_miles")
    private double avgVisMiles;

    @JsonProperty("avghumidity")
    private double avgHumidity;

    @JsonProperty("daily_will_it_rain")
    private int dailyWillItRain;

    @JsonProperty("daily_chance_of_rain")
    private int dailyChanceOfRain;

    @JsonProperty("daily_will_it_snow")
    private int dailyWillItSnow;

    @JsonProperty("daily_chance_of_snow")
    private int dailyChanceOfSnow;

    private Condition condition;

    @JsonProperty("uv")
    private double uv;

	
}
