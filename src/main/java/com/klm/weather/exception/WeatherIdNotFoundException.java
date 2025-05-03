package com.klm.weather.exception;

/**
 * Exception thrown when a weather record is not found by ID.
 */
public class WeatherIdNotFoundException extends RuntimeException {

    /**
     * Constructs a new WeatherIdNotFoundException with the specified message.
     *
     * @param message the detail message
     */
    public WeatherIdNotFoundException(String message) {
        super(message);
    }
}
