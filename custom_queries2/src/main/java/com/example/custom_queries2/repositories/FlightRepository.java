package com.example.custom_queries2.repositories;

import com.example.custom_queries2.entities.Flight;
import com.example.custom_queries2.entities.FlightStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("select f from Flight f order by fromAirport ASC")
    List<Flight> findAllByOrderByFromAirportAsc(PageRequest pageRequest);

    @Query("select f from Flight f where f.status = ONTIME")
    List<Flight> findByStatusOnTime(FlightStatus ONTIME);

    @Query
    List<Flight> findByStatus(FlightStatus p);
}