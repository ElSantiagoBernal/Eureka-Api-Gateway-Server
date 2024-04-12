package com.eam.flights.controller;

import com.eam.flights.dto.DestinyDTO;
import com.eam.flights.dto.Response;
import com.eam.flights.models.Destiny;
import com.eam.flights.servicies.impl.DestinyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destiny")
@AllArgsConstructor
public class DestinyController {
    private final DestinyServiceImpl destinyService;

    @PostMapping
    public ResponseEntity<Response<Destiny>> save(@RequestBody DestinyDTO destinyDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Response<>("Destino creado correctamente", destinyService.save(destinyDTO)) );
    }

    @GetMapping
    public ResponseEntity<Response<List<Destiny>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", destinyService.findAll()) );
    }

    @GetMapping("/{name}")
    public ResponseEntity<Response<Destiny>> findAll(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", destinyService.findByName(name)) );
    }
}
