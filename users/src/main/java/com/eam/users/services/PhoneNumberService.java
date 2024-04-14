package com.eam.users.services;

import com.eam.users.dto.PhoneNumberDTO;
import com.eam.users.models.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {

    public PhoneNumber save(PhoneNumberDTO phoneNumberDTO);

    public List<PhoneNumber> findAll();

    public PhoneNumber findByNumber(String phoneNumber);

    public PhoneNumber update(PhoneNumberDTO phoneNumberDTO);

    public PhoneNumber factory(PhoneNumberDTO phoneNumberDTO);
}
