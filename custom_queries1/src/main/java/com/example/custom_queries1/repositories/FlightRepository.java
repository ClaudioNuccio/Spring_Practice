package com.example.custom_queries1.repositories;

import com.example.custom_queries1.entities.Flight;
import com.example.custom_queries1.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    @Query(value = "SELECT * FROM Flight f WHERE flight_status LIKE 'ONTIME'",nativeQuery = true)
    List<Flight> flightStatus(FlightStatus ONTIME);
}