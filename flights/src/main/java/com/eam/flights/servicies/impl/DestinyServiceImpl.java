package com.eam.flights.servicies.impl;

import com.eam.flights.dto.DestinyDTO;
import com.eam.flights.models.Destiny;
import com.eam.flights.reposotories.DestinyRepository;
import com.eam.flights.servicies.DestinyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DestinyServiceImpl implements DestinyService {

    private final DestinyRepository destinyRepository;
    @Override
    public Destiny save(DestinyDTO destinyDTO){

        Optional<Destiny> guardado = destinyRepository.findByName(destinyDTO.getName());

        if(guardado.isPresent()){
            throw new RuntimeException("El destino con el nombre"+destinyDTO.getName()+" ya existe");
        }

        return destinyRepository.save(factory(destinyDTO));
    }
    @Override
    public Destiny findByName(String name){
        return destinyRepository.findByName(name).orElse(null);
    }
    @Override
    public List<Destiny> findAll(){
        return destinyRepository.findAll();
    }
    @Override
    public Destiny update(DestinyDTO destinyDTO){
        return destinyRepository.save( factory(destinyDTO) );
    }
    @Override
    public Destiny factory(DestinyDTO destinyDTO){

        Destiny nuevo = Destiny.builder()
                .name(destinyDTO.getName())
                .description(destinyDTO.getDescription())
                .build();
        return nuevo;
    }
}