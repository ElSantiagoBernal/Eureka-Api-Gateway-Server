package com.eam.users.dto;

import com.eam.users.models.Client;
import com.eam.users.models.PhoneNumber;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ClientDTO {
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String documentNumber;
    private String password;
    private PhoneNumber phoneNumber;
    private String city;
    private String email;
    private String role;

    public ClientDTO(Client client, PhoneNumber phoneNumber) {
        this.firstName = client.getFirstName();
        this.secondName =  client.getSecondName();
        this.firstSurname = client.getFirstSurname();
        this.secondSurname = client.getSecondSurname();
        this.documentNumber = client.getDocumentNumber();
        this.password = client.getPassword();
        this.phoneNumber = phoneNumber;
        this.city = client.getCity();
        this.email = client.getEmail();
        this.role = client.getRole();
    }
}
