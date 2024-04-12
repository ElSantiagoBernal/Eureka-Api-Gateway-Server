package com.eam.hosts.servicies;

import com.eam.hosts.dto.FeatureDTO;
import com.eam.hosts.models.Feature;

import java.util.List;

public interface FeatureService {

    public Feature save(FeatureDTO featureDTO);

    public List<Feature> findAll();

    public Feature update(FeatureDTO featureDTO);

    public Feature factory(FeatureDTO featureDTO);
}
