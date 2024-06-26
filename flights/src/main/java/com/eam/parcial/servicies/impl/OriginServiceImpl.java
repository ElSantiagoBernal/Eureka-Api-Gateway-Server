package com.eam.parcial.servicies.impl;

import com.eam.parcial.dto.OriginDTO;
import com.eam.parcial.models.Origin;
import com.eam.parcial.reposotories.OriginRepository;
import com.eam.parcial.servicies.OriginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OriginServiceImpl implements OriginService {

    private final OriginRepository originRepository;
    @Override
    public Origin save(OriginDTO originDTO){

        Optional<Origin> guardado = originRepository.findByName(originDTO.getName());

        if(guardado.isPresent()){
            throw new RuntimeException("El origen con el nombre "+originDTO.getName()+" ya existe");
        }

        return originRepository.save( factory(originDTO) );
    }

    @Override
    public Origin findByName(String name){
        return originRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Origin> findAll(){
        return originRepository.findAll();
    }

    @Override
    public Origin update(OriginDTO originDTO){
        return originRepository.save( factory(originDTO) );
    }

    @Override
    public Origin factory(OriginDTO originDTO){

        Origin nuevo = Origin.builder()
                .name(originDTO.getName())
                .description(originDTO.getDescription())
                .build();

        return nuevo;
    }
}
