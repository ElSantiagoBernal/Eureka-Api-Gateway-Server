package com.eam.parcial.servicies;

import com.eam.parcial.dto.FeatureDTO;
import com.eam.parcial.dto.HostDTO;
import com.eam.parcial.dto.PictureDTO;
import com.eam.parcial.models.Feature;
import com.eam.parcial.models.Host;
import com.eam.parcial.models.Picture;

import java.util.List;

public interface HostService {

    public Host save(HostDTO hostDTO, FeatureDTO featureDTO, PictureDTO pictureDTO);

    public List<Host> findAll();

    public Host findByName(String name);

    public Host update(HostDTO hostDTO, Feature feature, Picture picture);

    public Host factory(HostDTO hostDTO, Feature feature, Picture picture);

}
