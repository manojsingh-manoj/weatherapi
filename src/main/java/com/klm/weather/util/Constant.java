package com.klm.weather.util;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
/**
 * Utility class containing constants for the weather API.
 */
@UtilityClass
public class Constant {

    /** Error code for weather ID not found. */
    public static final String CODE_WEATHER_ID_NOT_FOUND    = "E1001";
    /** Error message for weather ID not found. */
    public static final String STR_WEATHER_ID_NOT_FOUND    = "Weather not found.";

    /** Error code for null weather ID. */
    public static final String CODE_WEATHER_ID_IS_NULL    = "E1002";
    /** Error message for null weather ID. */
    public static final String STR_WEATHER_ID_IS_NULL     = "Weather Id can not be null.";

    /** Date format for parsing and formatting dates. */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    /** Error code for invalid date format. */
    public static final String CODE_INVALID_DATE_FORMAT = "E1003";
    /** Error message for invalid date format. */
    public static final String STR_INVALID_DATE_FORMAT     = "Date format not correct.";

    /** Error code for invalid sort parameter. */
    public static final String CODE_INVALID_SORT_PARAM = "E1005";
    /** Error message for invalid sort parameter. */
    public static final String STR_INVALID_SORT_PARAM = "Invalid sort parameter.";
}
