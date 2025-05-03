package com.klm.weather.service;

import com.klm.weather.exception.WeatherIdNotFoundException;
import com.klm.weather.model.Weather;
import com.klm.weather.repository.WeatherRepository;
import com.klm.weather.util.Constant;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getWeather(String sort, String date, String city) {
        Sort sortCriteria = Sort.by(Sort.Direction.ASC, "id");
        return weatherRepository.findAll(sortCriteria);
    }

    public Weather getWeatherById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException(Constant.STR_WEATHER_ID_NOT_FOUND);
        }
        return weatherRepository.findById(id).orElseThrow(()-> new WeatherIdNotFoundException(Constant.STR_WEATHER_ID_NOT_FOUND));
    }

    public Weather addWeather(Weather weather) {
        return weatherRepository.save(weather);
    }

}
