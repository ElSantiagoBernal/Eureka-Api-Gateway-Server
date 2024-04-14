package com.eam.users.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PhoneNumberDTO {

    private String type;
    private String value;

}
