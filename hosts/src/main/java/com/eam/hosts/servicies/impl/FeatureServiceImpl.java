package com.eam.hosts.servicies.impl;

import com.eam.hosts.dto.FeatureDTO;
import com.eam.hosts.models.Feature;
import com.eam.hosts.reposotories.FeatureRepository;
import com.eam.hosts.reposotories.HostRepository;
import com.eam.hosts.servicies.FeatureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private final FeatureRepository featureRepository;

    @Autowired
    private final HostRepository hostRepository;

    @Override
    public Feature save(FeatureDTO featureDTO){

        return featureRepository.save(factory(featureDTO));
    }

    @Override
    public List<Feature> findAll(){
        return featureRepository.findAll();
    }

    @Override
    public Feature update(FeatureDTO featureDTO){
        return featureRepository.save( factory(featureDTO) );
    }

    @Override
    public Feature factory(FeatureDTO featureDTO){
        Feature nuevo = Feature.builder()
            .hasSwimmingPool(featureDTO.getHasSwimmingPool())
            .hasBuffet(featureDTO.getHasBuffet())
            .hasWifi(featureDTO.getHasBuffet())
            .hasFridge(featureDTO.getHasFridge())
            .build();

        return nuevo;
    }
}
