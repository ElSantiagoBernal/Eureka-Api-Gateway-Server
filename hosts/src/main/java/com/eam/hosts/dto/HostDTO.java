package com.eam.hosts.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class HostDTO {
    private String name;
    private Integer rating;
    private Double price;
    private Integer maximumCapacity;
    private String latitude;
    private String longitude;
}
