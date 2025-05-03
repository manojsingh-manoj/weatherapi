package com.klm.weather.model;

/**
 * Model representing an error response.
 */
public class Errors {


    private final String code;
    private final String message;

    /**
     * Constructs a new Errors object.
     *
     * @param code the error code
     * @param message the error message
     */
    public Errors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the error message.
     *
     * @return the error message
     */
    public String getMessage() {
        return message;
    }
}
