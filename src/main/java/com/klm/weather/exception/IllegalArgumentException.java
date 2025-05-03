package com.klm.weather.exception;

/**
 * Exception thrown when an invalid argument is provided.
 */
public class IllegalArgumentException extends RuntimeException {

    /**
     * Constructs a new IllegalArgumentException with the specified message.
     *
     * @param message the detail message
     */
    public IllegalArgumentException(String message) {
        super(message);
    }
}
