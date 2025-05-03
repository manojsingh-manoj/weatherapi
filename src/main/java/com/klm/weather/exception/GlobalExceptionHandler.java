package com.klm.weather.exception;

import com.klm.weather.model.Errors;
import com.klm.weather.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the weather API.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles WeatherIdNotFoundException and returns a 404 response.
     *
     * @param ex the exception
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {WeatherIdNotFoundException.class})
    public ResponseEntity<Errors> handleWeatherIdNotFoundException(WeatherIdNotFoundException weatherIdNotFoundException) {
        Errors errors = new Errors(Constant.CODE_WEATHER_ID_NOT_FOUND, weatherIdNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    /**
     * Handles IllegalArgumentException and returns a 404 response.
     *
     * @param ex the exception
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Errors> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        Errors errors = new Errors(Constant.CODE_WEATHER_ID_IS_NULL, illegalArgumentException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    /**
     * Handles InvalidDateFormatException and returns a 404 response.
     *
     * @param ex the exception
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {InvalidDateFormatException.class})
    public ResponseEntity<Errors> handleInvalidDateFormatException(InvalidDateFormatException invalidDateFormatException) {
        Errors errors = new Errors(Constant.CODE_INVALID_DATE_FORMAT, invalidDateFormatException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }
}
