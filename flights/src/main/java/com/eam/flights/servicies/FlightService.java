package com.eam.flights.servicies;

import com.eam.flights.dto.FlightDTO;
import com.eam.flights.dto.OriginDTO;
import com.eam.flights.models.Destiny;
import com.eam.flights.models.Flight;
import com.eam.flights.models.Origin;
import com.eam.flights.reposotories.DestinyRepository;
import com.eam.flights.reposotories.FlightRepository;
import com.eam.flights.reposotories.OriginRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    private final OriginRepository originRepository;

    private final DestinyRepository destinyRepository;


    public Flight save(FlightDTO flightDTO){

        Origin origin = originRepository.findById(flightDTO.getOriginId()).orElse(null);
        Destiny  destiny = destinyRepository.findById(flightDTO.getDestinyId()).orElse(null);
        if(origin != null && destiny != null){
            Optional<Flight> guardado = flightRepository.findByPlate(flightDTO.getPlate());

            if(guardado.isPresent()){
                throw new RuntimeException("El vuelo con la matricula"+flightDTO.getPlate()+" ya existe");
            }

            return flightRepository.save( factory(flightDTO) );
        }

        throw new RuntimeException("El destino u origen del vuelo no esta registrado");
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
                .airline(flightDTO.getAirline())
                .plate(flightDTO.getPlate())
                .departureDate(flightDTO.getDepartureDate())
                .returnDate(flightDTO.getReturnDate())
                .isDirect(flightDTO.getIsDirect())
                .durationHours(flightDTO.getDurationHours())
                .passengersNumber(flightDTO.getPassengersNumber())
                .destiny()
                .build();

        return nuevo;
    }

}
