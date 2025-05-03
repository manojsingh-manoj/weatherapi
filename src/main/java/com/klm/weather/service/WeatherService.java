package com.klm.weather.service;

import com.klm.weather.exception.InvalidDateFormatException;
import com.klm.weather.exception.WeatherIdNotFoundException;
import com.klm.weather.model.Weather;
import com.klm.weather.repository.WeatherRepository;
import com.klm.weather.util.Constant;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getWeather(String sort, String date, String city) {
        Sort sortCriteria = Sort.by(Sort.Direction.ASC, "id");
        if (sort != null) {
            sortCriteria = sort.startsWith("-") ? Sort.by(Sort.Direction.DESC, sort.substring(1)) : Sort.by(Sort.Direction.ASC, sort);
        }
        if (date != null && city != null) {
            Date ldate =  getParsedDate(date);
            return weatherRepository.findByDateAndCityIn(sortCriteria, getParsedDate(date), getEndDate(ldate),List.of(city.toLowerCase().split(",")));
        } else if (date != null) {
            Date ldate =  getParsedDate(date);
            return weatherRepository.findByDateBetween(ldate,getEndDate(ldate),sortCriteria);
            //return weatherRepository.findByDate(sortCriteria, getParsedDate(date));
        } else if (city != null) {
            return weatherRepository.findByCityInIgnoreCase(List.of(city.toLowerCase().split(",")),sortCriteria);
        }

        return weatherRepository.findAll(sortCriteria);
    }

    private static Date getEndDate(Date ldate) {
        Calendar c = Calendar.getInstance();
        c.setTime(ldate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }

    private static Date getParsedDate(String date) {
        try {
            return Constant.DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new InvalidDateFormatException(Constant.STR_INVALID_DATE_FORMAT);
        }
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
