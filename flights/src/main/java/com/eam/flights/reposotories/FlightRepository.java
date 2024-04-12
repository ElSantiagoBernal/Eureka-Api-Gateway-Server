package com.eam.flights.reposotories;

import com.eam.flights.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByPlate(String plate);

}
