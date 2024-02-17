package com.app.weather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
     @CrossOrigin(origins="*")
	@GetMapping("/currentWeather")
	public ResponseEntity<String> getCurrentWeatherReport(@RequestParam(name="city") String cityName) {
    	 ResponseEntity<String> response=null;
    	 try {
    	 System.out.println(cityName);
		RestTemplate template = new RestTemplate();
		String url = "http://api.weatherapi.com/v1/current.json?key=b91006a5ba4e49758cb115315240802&q="+cityName+"&aqi=no";
		 response = template.getForEntity(url, String.class);
    	 }
    	 catch(Exception e) {
    		 return response;
    	 }
		return response;
	}
}