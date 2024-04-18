package com.eam.parcial.servicies.impl;

import com.eam.parcial.dto.FeatureDTO;
import com.eam.parcial.dto.HostDTO;
import com.eam.parcial.dto.PictureDTO;
import com.eam.parcial.models.Feature;
import com.eam.parcial.models.Host;
import com.eam.parcial.models.Picture;
import com.eam.parcial.reposotories.HostRepository;
import com.eam.parcial.servicies.FeatureService;
import com.eam.parcial.servicies.HostService;
import com.eam.parcial.servicies.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HostServiceImpl implements HostService {

    @Autowired
    private final FeatureService featureService;

    @Autowired
    private final HostRepository hostRepository;

    @Autowired
    private final PictureService pictureService;

    @Override
    public Host save(HostDTO hostDTO, FeatureDTO featureDTO, PictureDTO pictureDTO){
        Optional<Host> guardado = hostRepository.findByName(hostDTO.getName());

        if(guardado.isPresent()){
            throw new RuntimeException("El alojamiento con el nombre"+hostDTO.getName()+" ya existe");
        }
        Feature feature = featureService.save(featureDTO);
        Picture picture = pictureService.save(pictureDTO);
        return hostRepository.save(factory(hostDTO, feature, picture));


    }

    @Override
    public List<Host> findAll(){
        return hostRepository.findAll();
    }

    public Host findByName(String name){
        return hostRepository.findByName(name).orElse(null);
    }

    @Override
    public Host update(HostDTO hostDTO, Feature feature, Picture picture){
        return hostRepository.save( factory(hostDTO, feature, picture) );
    }

    @Override
    public Host factory(HostDTO hostDTO, Feature feature, Picture picture){
        Host nuevo = Host.builder()
                .name(hostDTO.getName())
                .rating(hostDTO.getRating())
                .price(hostDTO.getPrice())
                .maximumCapacity(hostDTO.getMaximumCapacity())
                .latitude(hostDTO.getLatitude())
                .longitude(hostDTO.getLongitude())
                .picture(picture)
                .feature(feature)
                .build();

        return nuevo;
    }


}
