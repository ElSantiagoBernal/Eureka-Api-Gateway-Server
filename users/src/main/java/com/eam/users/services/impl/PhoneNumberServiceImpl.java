package com.eam.users.services.impl;

import com.eam.users.dto.PhoneNumberDTO;
import com.eam.users.models.PhoneNumber;
import com.eam.users.repositories.PhoneNumberRepository;
import com.eam.users.services.PhoneNumberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneNumberServiceImpl implements PhoneNumberService{

    @Autowired
    private final PhoneNumberRepository phoneNumberRepository;


    @Override
    public PhoneNumber save(PhoneNumberDTO phoneNumberDTO){

        return phoneNumberRepository.save(factory(phoneNumberDTO));
    }

    @Override
    public List<PhoneNumber> findAll(){
        return phoneNumberRepository.findAll();
    }

    @Override
    public PhoneNumber findByNumber(String phoneNumber) {
        return phoneNumberRepository.findByNumber(phoneNumber).orElse(null);
    }

    @Override
    public PhoneNumber update(PhoneNumberDTO phoneNumberDTO){
        return phoneNumberRepository.save( factory(phoneNumberDTO) );
    }

    @Override
    public PhoneNumber factory(PhoneNumberDTO phoneNumberDTO){
        PhoneNumber nuevo = PhoneNumber.builder()
                .type(phoneNumberDTO.getType())
                .value(phoneNumberDTO.getValue())
                .build();

        return nuevo;
    }
}
