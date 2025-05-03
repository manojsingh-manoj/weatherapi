package com.klm.weather.controller;

import com.klm.weather.model.Weather;
import com.klm.weather.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing weather data.
 */
@RestController
@RequestMapping("/weather")
@Tag(name="Weather", description = "API for Weather Service")
public class WeatherApiRestController {

    private final WeatherService weatherService;

    /**
     * Constructs a WeatherApiRestController with the specified WeatherService.
     *
     * @param weatherService the service to handle weather-related operations
     */
    public WeatherApiRestController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Retrieves a list of weather records based on optional filters.
     *
     * @param sort optional sorting criteria (e.g., "date" or "-date")
     * @param date optional date filter in YYYY-MM-DD format
     * @param city optional city filter (case-insensitive, comma-separated)
     * @return a ResponseEntity containing the list of matching weather records
     */
    @Operation(summary = "Get Weather")
    @ApiResponse(responseCode = "200", description = "List of weather retrieved successfully")
    @GetMapping
    public ResponseEntity<List<Weather>> getWeather(@RequestParam(required = false) String sort, @RequestParam(required = false) String date, @RequestParam(required = false) String city) {
        return ResponseEntity.ok().body(weatherService.getWeather(sort, date, city));
    }

    /**
     * Retrieves a weather record by its ID.
     *
     * @param id the ID of the weather record
     * @return a ResponseEntity containing the weather record, or 404 if not found
     */
    @Operation(summary = "Get Weather By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Weather found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Weather.class))),
            @ApiResponse(responseCode = "404", description = "Weather not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Weather> getWeatherById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(weatherService.getWeatherById(id));
    }

    /**
     * Creates a new weather record.
     *
     * @param weather the weather data to create
     * @return a ResponseEntity containing the created weather record with its assigned ID
     */
    @Operation(summary = "Add Weather")
    @ApiResponse(responseCode = "201", description = "Weather created successfully")
    @PostMapping()
    public ResponseEntity<Weather> addWeather(@RequestBody Weather weather) {
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherService.addWeather(weather));
    }
}
