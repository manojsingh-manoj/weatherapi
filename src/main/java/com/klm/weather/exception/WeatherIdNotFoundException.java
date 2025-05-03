package com.klm.weather.exception;

public class WeatherIdNotFoundException extends RuntimeException {
    public WeatherIdNotFoundException(String message) {
        super(message);
    }
}
