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

    @Query("SELECT w FROM Weather w WHERE LOWER(w.city) IN :cities")
    List<Weather> findByCityInIgnoreCase(@Param("cities") List<String> citiesLower, Sort sort);

    List<Weather> findByDate(Sort sortCriteria, Date date);
    @Query("SELECT w FROM Weather w WHERE LOWER(w.city) IN :cities AND w.date between :dateBefore AND :dateAfter")
    List<Weather> findByDateAndCityIn(Sort sortCriteria, Date dateBefore, Date dateAfter, List<String> city);

    List<Weather> findByDateBetween(Date dateBefore, Date dateAfter, Sort sort);

}
