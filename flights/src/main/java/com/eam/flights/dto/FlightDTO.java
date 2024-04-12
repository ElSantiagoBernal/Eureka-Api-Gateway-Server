package com.eam.flights.dto;

import com.eam.flights.models.Destiny;
import com.eam.flights.models.Origin;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class FlightDTO {

    private String airline;
    private Date departureDate;
    private Date returnDate;
    private Boolean isDirect;
    private Integer durationHours;
    private Integer originId;
    private Integer destinyId;

}
