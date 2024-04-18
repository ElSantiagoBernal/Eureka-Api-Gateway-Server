package com.eam.parcial.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "clients")
@Builder
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;

    @Column(nullable = false)
    private String firstSurname;

    @Column(nullable = false)
    private String secondSurname;

    @Column(nullable = false)
    private String documentNumber;

    @Column(nullable = false)
    private String password;

    @OneToOne(optional = true)
    @JoinColumn(name = "phone_numbers", referencedColumnName = "id")
    private PhoneNumber phoneNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

}
