package com.eam.parcial.servicies.impl;

import com.eam.parcial.dto.FlightDTO;
import com.eam.parcial.models.Destiny;
import com.eam.parcial.models.Flight;
import com.eam.parcial.models.Origin;
import com.eam.parcial.reposotories.DestinyRepository;
import com.eam.parcial.reposotories.FlightRepository;
import com.eam.parcial.reposotories.OriginRepository;
import com.eam.parcial.servicies.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    private final OriginRepository originRepository;

    private final DestinyRepository destinyRepository;

    @Override
    public Flight save(FlightDTO flightDTO){

        Origin origin = originRepository.findById(flightDTO.getOriginId()).orElse(null);
        Destiny  destiny = destinyRepository.findById(flightDTO.getDestinyId()).orElse(null);
        if(origin != null && destiny != null){
            Optional<Flight> guardado = flightRepository.findByPlate(flightDTO.getPlate());

            if(guardado.isPresent()){
                throw new RuntimeException("El vuelo con la matricula"+flightDTO.getPlate()+" ya existe");
            }

            return flightRepository.save( factory(flightDTO, destiny, origin) );
        }

        throw new RuntimeException("El destino u origen del vuelo no esta registrado");
    }

    @Override
    public Flight findByPlate(String plate){
        return flightRepository.findByPlate(plate).orElse(null);
    }

    @Override
    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

    @Override
    public Flight update(FlightDTO flightDTO, Destiny destiny, Origin origin){
        return flightRepository.save( factory(flightDTO, destiny, origin) );
    }

    @Override
    public Flight factory(FlightDTO flightDTO, Destiny destiny, Origin origin){

        Flight nuevo = Flight.builder()
                .airline(flightDTO.getAirline())
                .plate(flightDTO.getPlate())
                .departureDate(flightDTO.getDepartureDate())
                .returnDate(flightDTO.getReturnDate())
                .isDirect(flightDTO.getIsDirect())
                .durationHours(flightDTO.getDurationHours())
                .passengersNumber(flightDTO.getPassengersNumber())
                .destiny(destiny)
                .origin(origin)
                .build();

        return nuevo;
    }

}
