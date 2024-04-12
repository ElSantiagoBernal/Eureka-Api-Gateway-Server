package com.eam.flights.servicies;

import com.eam.flights.dto.FlightDTO;
import com.eam.flights.models.Flight;
import com.eam.flights.reposotories.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public Flight save(FlightDTO flightDTO){

        Optional<Flight> guardado = flightRepository.findById(flightDTO.id());

        if(guardado.isPresent()){
            throw new RuntimeException("El autor con el isbn "+flightDTO.id()+" ya existe");
        }

        return flightRepository.save( factory(flightDTO) );
    }

    public Flight findById(Long id){
        return flightRepository.findById(id).orElse(null);
    }

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

    public Flight update(FlightDTO flightDTO){
        return flightRepository.save( factory(flightDTO) );
    }

    private Flight factory(FlightDTO flightDTO){

        Flight nuevo = Flight.builder()
                .id(flightDTO.id())
                .nombre(flightDTO.nombre())
                .build();

        return nuevo;
    }

}
