package com.eam.flights.servicies;

import com.eam.flights.dto.DestinyDTO;
import com.eam.flights.dto.OriginDTO;
import com.eam.flights.models.Destiny;
import com.eam.flights.models.Origin;
import com.eam.flights.reposotories.DestinyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DestinyService {

    private final DestinyRepository destinyRepository;

    public Destiny save(DestinyDTO destinyDTO){

        Optional<Destiny> guardado = destinyRepository.findById(destinyDTO.getId());

        if(guardado.isPresent()){
            throw new RuntimeException("El destino con el id "+destinyDTO.getId()+" ya existe");
        }

        return destinyRepository.save(factory(destinyDTO));
    }

    public Destiny findById(Long id){
        return destinyRepository.findById(id).orElse(null);
    }

    public List<Destiny> findAll(){
        return destinyRepository.findAll();
    }

    public Destiny update(DestinyDTO destinyDTO){
        return destinyRepository.save( factory(destinyDTO) );
    }

    private Destiny factory(DestinyDTO destinyDTO){

        Destiny nuevo = Destiny.builder()
                .name(destinyDTO.getName())
                .description(destinyDTO.getDescription())
                .build();

        return nuevo;
    }
}
