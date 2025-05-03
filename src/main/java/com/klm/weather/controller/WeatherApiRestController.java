package com.klm.weather.controller;

import com.klm.weather.model.Weather;
import com.klm.weather.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {

    private final WeatherService weatherService;

    public WeatherApiRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping
    public ResponseEntity<List<Weather>> getWeather(@RequestParam(required = false) String sort, @RequestParam(required = false) String date, @RequestParam(required = false) String city) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weather> getWeatherById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(weatherService.getWeatherById(id));
    }

    @PostMapping()
    public ResponseEntity<Weather> addWeather(@RequestBody Weather weather) {
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherService.addWeather(weather));
    }
}
