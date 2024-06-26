package com.eam.parcial.controller;

import com.eam.parcial.dto.FlightDTO;
import com.eam.parcial.dto.Response;
import com.eam.parcial.models.Flight;
import com.eam.parcial.servicies.impl.FlightServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
@AllArgsConstructor
public class FlightController {

    private final FlightServiceImpl flightService;

    @PostMapping
    public ResponseEntity<Response<Flight>> save(@RequestBody FlightDTO flightDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Response<>("Vuelo creado correctamente", flightService.save(flightDTO)) );
    }

    @GetMapping
    public ResponseEntity<Response<List<Flight>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", flightService.findAll()) );
    }

    @GetMapping("/{plate}")
    public ResponseEntity<Response<Flight>> findAll(@PathVariable String plate){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", flightService.findByPlate(plate)) );
    }
}
