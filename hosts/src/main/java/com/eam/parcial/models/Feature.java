package com.eam.parcial.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "features")
@Builder
@AllArgsConstructor
public class Feature {

    @Id
    private Integer id;

    @Column(nullable = false)
    private Boolean hasSwimmingPool;

    @Column(nullable = false)
    private Boolean hasBuffet;

    @Column(nullable = false)
    private Boolean hasWifi;

    @Column(nullable = false)
    private Boolean hasFridge;

}
