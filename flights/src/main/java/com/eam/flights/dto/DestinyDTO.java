package com.eam.flights.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DestinyDTO {

    private long id;
    private String name;
    private String description;

}
