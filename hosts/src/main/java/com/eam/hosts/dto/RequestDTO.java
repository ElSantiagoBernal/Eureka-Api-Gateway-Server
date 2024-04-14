package com.eam.hosts.dto;

import lombok.Data;

@Data
public class RequestDTO {

    private HostDTO hostDTO;
    private FeatureDTO featureDTO;
    private PictureDTO pictureDTO;

}
