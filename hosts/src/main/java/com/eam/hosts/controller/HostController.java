package com.eam.hosts.controller;

import com.eam.hosts.dto.FeatureDTO;
import com.eam.hosts.dto.HostDTO;
import com.eam.hosts.dto.PictureDTO;
import com.eam.hosts.dto.Response;
import com.eam.hosts.models.Host;
import com.eam.hosts.servicies.HostService;
import com.eam.hosts.servicies.impl.HostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/host")
@AllArgsConstructor
public class HostController {

    private final HostService hostService;

    @PostMapping
    public ResponseEntity<Response<Host>> save(@RequestBody HostDTO hostDTO, @RequestBody FeatureDTO featureDTO, @RequestBody PictureDTO pictureDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Response<>("Alojamiento creado correctamente", hostService.save(hostDTO, featureDTO, pictureDTO)) );
    }

    @GetMapping
    public ResponseEntity<Response<List<Host>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", hostService.findAll()) );
    }

    @GetMapping("/{name}")
    public ResponseEntity<Response<Host>> findAll(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", hostService.findByName(name)) );
    }

}
