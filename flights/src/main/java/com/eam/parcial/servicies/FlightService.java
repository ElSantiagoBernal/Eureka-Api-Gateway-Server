package com.eam.parcial.servicies;

import com.eam.parcial.dto.FlightDTO;
import com.eam.parcial.models.Destiny;
import com.eam.parcial.models.Flight;
import com.eam.parcial.models.Origin;

import java.util.List;

public interface FlightService {

    public Flight save(FlightDTO flightDTO);

    public Flight findByPlate(String plate);

    public List<Flight> findAll();

    public Flight update(FlightDTO flightDTO, Destiny destiny, Origin origin);

    public Flight factory(FlightDTO flightDTO, Destiny destiny, Origin origin);
}
