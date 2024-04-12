package com.eam.flights.servicies;

import com.eam.flights.dto.FlightDTO;
import com.eam.flights.models.Destiny;
import com.eam.flights.models.Flight;
import com.eam.flights.models.Origin;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    public Flight save(FlightDTO flightDTO);

    public Flight findByPlate(String plate);

    public List<Flight> findAll();

    public Flight update(FlightDTO flightDTO, Destiny destiny, Origin origin);

    public Flight factory(FlightDTO flightDTO, Destiny destiny, Origin origin);
}
