package com.eam.flights.controller;

import com.eam.flights.dto.FlightDTO;
import com.eam.flights.dto.Response;
import com.eam.flights.models.Flight;
import com.eam.flights.servicies.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
@AllArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<Response<Flight>> save(@RequestBody FlightDTO flightDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Response<>("Autor creado correctamente", flightService.save(flightDTO)) );
    }

    @GetMapping
    public ResponseEntity<Response<List<Flight>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", flightService.findAll()) );
    }

    @GetMapping("/{isbnAutor}")
    public ResponseEntity<Response<Flight>> findAll(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", flightService.findById(id)) );
    }
}
