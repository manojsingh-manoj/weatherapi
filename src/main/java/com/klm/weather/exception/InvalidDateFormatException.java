package com.klm.weather.exception;

/**
 * Exception thrown when an invalid date format is provided.
 */
public class InvalidDateFormatException extends RuntimeException {

    /**
     * Constructs a new InvalidDateFormatException with the specified message.
     *
     * @param message the detail message
     */
    public InvalidDateFormatException(String message) {
        super(message);
    }
}
