package com.eam.parcial.controller;

import com.eam.parcial.dto.OriginDTO;
import com.eam.parcial.dto.Response;
import com.eam.parcial.models.Origin;
import com.eam.parcial.servicies.impl.OriginServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/origin")
@AllArgsConstructor
public class OriginController {

    private final OriginServiceImpl originService;

    @PostMapping
    public ResponseEntity<Response<Origin>> save(@RequestBody OriginDTO originDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Response<>("Origen creado correctamente", originService.save(originDTO)) );
    }

    @GetMapping
    public ResponseEntity<Response<List<Origin>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", originService.findAll()) );
    }

    @GetMapping("/{name}")
    public ResponseEntity<Response<Origin>> findAll(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", originService.findByName(name)) );
    }
}
