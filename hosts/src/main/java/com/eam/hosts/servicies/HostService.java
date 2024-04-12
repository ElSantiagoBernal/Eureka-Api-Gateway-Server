package com.eam.hosts.servicies;

import com.eam.hosts.dto.FeatureDTO;
import com.eam.hosts.dto.HostDTO;
import com.eam.hosts.dto.PictureDTO;
import com.eam.hosts.models.Feature;
import com.eam.hosts.models.Host;
import com.eam.hosts.models.Picture;

import java.util.List;
import java.util.Optional;

public interface HostService {

    public Host save(HostDTO hostDTO, FeatureDTO featureDTO, PictureDTO pictureDTO);

    public List<Host> findAll();

    public Host findByName(String name);

    public Host update(HostDTO hostDTO, Feature feature, Picture picture);

    public Host factory(HostDTO hostDTO, Feature feature, Picture picture);

}
