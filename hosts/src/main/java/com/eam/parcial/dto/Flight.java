package com.eam.parcial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Flight {

    private Integer id;
    private String airline;
    private String plate;
    private Date departureDate;
    private Date returnDate;
    private Boolean isDirect;
    private Integer durationHours;
    private Integer passengersNumber;
    private Origin origin;
    private Destiny destiny;

}
