package com.klm.weather.util;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;

@UtilityClass
public class Constant {

    public static final String CODE_WEATHER_ID_NOT_FOUND    = "E1001";
    public static final String STR_WEATHER_ID_NOT_FOUND    = "Weather not found.";

    public static final String CODE_WEATHER_ID_IS_NULL    = "E1002";
    public static final String STR_WEATHER_ID_IS_NULL     = "Weather Id can not be null.";

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final String CODE_INVALID_DATE_FORMAT = "E1003";
    public static final String STR_INVALID_DATE_FORMAT     = "Date format not correct.";
}
