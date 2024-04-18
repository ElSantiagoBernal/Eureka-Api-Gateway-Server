package com.eam.parcial.servicies;

import com.eam.parcial.dto.FeatureDTO;
import com.eam.parcial.models.Feature;

import java.util.List;

public interface FeatureService {

    public Feature save(FeatureDTO featureDTO);

    public List<Feature> findAll();

    public Feature update(FeatureDTO featureDTO);

    public Feature factory(FeatureDTO featureDTO);
}
