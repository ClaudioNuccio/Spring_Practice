package com.example.custom_queries2.controllers;

import com.example.custom_queries2.entities.Flight;
import com.example.custom_queries2.entities.FlightStatus;
import com.example.custom_queries2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

    @RestController
    @RequestMapping("/flights")
    public class FlightController {
        @Autowired
        private FlightRepository flightRepository;

        @PostMapping("/provisioning")
        public List<Flight> fillListOfFlight(@RequestParam(required = false) Integer n) {
            if (n == null) {
                n = 100;
            }
            for (int i = 1; i <= n; i++) {
                Random randomNumbers = new Random();
                Integer int_description = randomNumbers.nextInt(999999);
                Integer int_fromAirport = randomNumbers.nextInt(999999);
                Integer int_toAirport = randomNumbers.nextInt(999999);
                Integer int_flightStatus = randomNumbers.nextInt(3);
                String descriptionString = int_description.toString();
                String fromAirportString = int_fromAirport.toString();
                String toAirportString = int_toAirport.toString();
                FlightStatus status = switch (int_flightStatus) {
                    case 0 -> FlightStatus.ONTIME;
                    case 1 -> FlightStatus.DELAYED;
                    default -> FlightStatus.CANCELLED;
                };
                Flight flight = new Flight();
                flight.setDescription(descriptionString);
                flight.setFromAirport(fromAirportString);
                flight.setToAirport(toAirportString);
                flight.setStatus(status);
                flightRepository.saveAndFlush(flight);
            }
            return flightRepository.findAll();
        }

        @GetMapping("/retrieving")
        public List<Flight> getListOfFlight() {
            return flightRepository.findAll();
        }

        @GetMapping("/from/airport/asc")
        public List<Flight> findAllByOrderByFromAirportAsc(@RequestParam(required = false) Integer page, @RequestParam Integer size) {
            PageRequest pages = PageRequest.of(page, size, Sort.by("fromAirport").ascending());
            return flightRepository.findAllByOrderByFromAirportAsc(pages);
        }

        @GetMapping("/status/ontime")
        public List<Flight> findByStatusOnTime() {
            return flightRepository.findByStatusOnTime(FlightStatus.ONTIME);
        }

        @GetMapping("/status")
        public List<Flight> findByStatus(@RequestParam String status1, @RequestParam String status2) {
            List<Flight> list = new ArrayList<>();
            String statusString1 = status1.toUpperCase();
            String statusString2 = status2.toUpperCase();
            FlightStatus s1 = FlightStatus.valueOf(statusString1);
            FlightStatus s2 = FlightStatus.valueOf(statusString2);
            list.addAll(flightRepository.findByStatus(s1));
            list.addAll(flightRepository.findByStatus(s2));
            list.sort(Comparator.comparing(Flight::getId));
            return list;
        }
    }

