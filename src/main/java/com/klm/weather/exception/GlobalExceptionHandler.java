package com.klm.weather.exception;

import com.klm.weather.model.Errors;
import com.klm.weather.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the weather API.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles WeatherIdNotFoundException and returns a 404 response.
     *
     * @param weatherIdNotFoundException the exception
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {WeatherIdNotFoundException.class})
    public ResponseEntity<Errors> handleWeatherIdNotFoundException(WeatherIdNotFoundException weatherIdNotFoundException) {
        logger.error("WeatherIdNotFoundException: {}", weatherIdNotFoundException.getMessage());
        Errors errors = new Errors(Constant.CODE_WEATHER_ID_NOT_FOUND, weatherIdNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    /**
     * Handles IllegalArgumentException and returns a 404 response.
     *
     * @param illegalArgumentException the exception
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Errors> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        logger.error("IllegalArgumentException: {}", illegalArgumentException.getMessage());
        Errors errors = new Errors(Constant.CODE_WEATHER_ID_IS_NULL, illegalArgumentException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    /**
     * Handles InvalidDateFormatException and returns a 404 response.
     *
     * @param invalidDateFormatException the exception
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {InvalidDateFormatException.class})
    public ResponseEntity<Errors> handleInvalidDateFormatException(InvalidDateFormatException invalidDateFormatException) {
        logger.error("InvalidDateFormatException: {}", invalidDateFormatException.getMessage());
        Errors errors = new Errors(Constant.CODE_INVALID_DATE_FORMAT, invalidDateFormatException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
    }

    /**
     * Handles PropertyReferenceException for invalid sort parameters and returns a 400 response. Ex:http://localhost:8000/weather?sort=-date/city=city1,city2
     *
     * @param ex the exception
     * @return a ResponseEntity containing the error details
     */
    @ExceptionHandler(value = {PropertyReferenceException.class})
    public ResponseEntity<Errors> handlePropertyReferenceException(PropertyReferenceException ex) {
        logger.error("Invalid sort parameter: {}", ex.getMessage());
        Errors errors = new Errors(Constant.CODE_INVALID_SORT_PARAM, "Invalid sort parameter: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
