package com.eam.flights.servicies;

import com.eam.flights.dto.OriginDTO;
import com.eam.flights.models.Origin;
import com.eam.flights.reposotories.OriginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OriginService {

    private final OriginRepository originRepository;

    public Origin save(OriginDTO originDTO){

        Optional<Origin> guardado = originRepository.findById(originDTO.getId());

        if(guardado.isPresent()){
            throw new RuntimeException("El vuelo con el id "+originDTO.getId()+" ya existe");
        }

        return originRepository.save( factory(originDTO) );
    }

    public Origin findById(Long id){
        return originRepository.findById(id).orElse(null);
    }

    public List<Origin> findAll(){
        return originRepository.findAll();
    }

    public Origin update(OriginDTO originDTO){
        return originRepository.save( factory(originDTO) );
    }

    private Origin factory(OriginDTO originDTO){

        Origin nuevo = Origin.builder()
                .name(originDTO.getName())
                .description(originDTO.getDescription())
                .build();

        return nuevo;
    }
}
