package com.eam.flights.controller;

import com.eam.flights.dto.DestinyDTO;
import com.eam.flights.dto.OriginDTO;
import com.eam.flights.dto.Response;
import com.eam.flights.models.Destiny;
import com.eam.flights.models.Origin;
import com.eam.flights.servicies.DestinyService;
import com.eam.flights.servicies.OriginService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/origin")
@AllArgsConstructor
public class OriginController {

    private final OriginService originService;

    @PostMapping
    public ResponseEntity<Response<Origin>> save(@RequestBody OriginDTO originDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Response<>("Vuelo creado correctamente", originService.save(originDTO)) );
    }

    @GetMapping
    public ResponseEntity<Response<List<Origin>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", originService.findAll()) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Origin>> findAll(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", originService.findById(id)) );
    }
}
