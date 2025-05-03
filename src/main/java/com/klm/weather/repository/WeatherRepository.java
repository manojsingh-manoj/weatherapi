package com.klm.weather.repository;

import com.klm.weather.model.Weather;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    /**
     * Finds weather records by city (case-insensitive).
     *
     * @param citiesLower the list of city names (lowercase)
     * @param sort the sorting criteria
     * @return a list of matching weather records
     */
    @Query("SELECT w FROM Weather w WHERE LOWER(w.city) IN :cities")
    List<Weather> findByCityInIgnoreCase(@Param("cities") List<String> citiesLower, Sort sort);

    /**
     * Finds weather records by date.
     *
     * @param sortCriteria the sorting criteria
     * @param date the date to filter by
     * @return a list of matching weather records
     */
    List<Weather> findByDate(Sort sortCriteria, Date date);

    /**
     * Finds weather records by date range and city.
     *
     * @param sortCriteria the sorting criteria
     * @param dateBefore the start date
     * @param dateAfter the end date
     * @param city the list of city names (lowercase)
     * @return a list of matching weather records
     */
    @Query("SELECT w FROM Weather w WHERE LOWER(w.city) IN :cities AND w.date between :dateBefore AND :dateAfter")
    List<Weather> findByDateAndCityIn(Sort sortCriteria, Date dateBefore, Date dateAfter, List<String> city);

    /**
     * Finds weather records within a date range.
     *
     * @param dateBefore the start date
     * @param dateAfter the end date
     * @param sort the sorting criteria
     * @return a list of matching weather records
     */
    List<Weather> findByDateBetween(Date dateBefore, Date dateAfter, Sort sort);

}
