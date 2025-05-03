package com.klm.weather.service;

import com.klm.weather.model.Weather;
import com.klm.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getWeather(String sort, String date, String city) {
        return null;
    }

    public Weather getWeatherById(Integer id) {
        return null;
    }

    public Weather addWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

}
