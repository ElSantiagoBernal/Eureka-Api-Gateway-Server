package com.eam.users.controller;

import com.eam.users.dto.ClientDTO;
import com.eam.users.dto.Response;
import com.eam.users.models.Client;
import com.eam.users.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Response<Client>> save(@RequestBody ClientDTO clientDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body( new Response<>("Alojamiento creado correctamente", clientService.save(clientDTO)) );
    }

    @GetMapping
    public ResponseEntity<Response<List<Client>>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", clientService.findAll()) );
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<Response<ClientDTO>> findAll(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body( new Response<>("", clientService.findByDocumentNumber(name)) );
    }
}
