package com.eam.users.services.impl;

import com.eam.users.dto.ClientDTO;
import com.eam.users.models.Client;
import com.eam.users.models.PhoneNumber;
import com.eam.users.repositories.ClientRepository;
import com.eam.users.services.ClientService;
import com.eam.users.services.PhoneNumberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    @Autowired
    private final PhoneNumberService phoneNumberService;

    @Override
    public Client save(ClientDTO clientDTO){

        PhoneNumber phoneNumber = phoneNumberService.findByNumber(clientDTO.getPhoneNumber().getValue());

        if(phoneNumber == null){
            Optional<Client> guardado = clientRepository.findByDocumentNumber(clientDTO.getDocumentNumber());

            if(guardado.isPresent()){
                throw new RuntimeException("El cliente con id: "+clientDTO.getDocumentNumber()+", ya existe");
            }

            return clientRepository.save(factory(clientDTO));
        }
        throw new RuntimeException("El telefono: "+phoneNumber.getValue()+", ya existe");
    }

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public ClientDTO findByDocumentNumber(String documentNumber) {
        Client client = clientRepository.findByDocumentNumber(documentNumber).orElse(null);
        PhoneNumber phoneNumber = phoneNumberService.findByNumber(client.getPhoneNumber().getValue());
        ClientDTO clientDTO = new ClientDTO(client, phoneNumber);
        return  clientDTO;
    }

    @Override
    public Client update(ClientDTO clientDTO){
        return clientRepository.save( factory(clientDTO) );
    }

    @Override
    public Client factory(ClientDTO clientDTO){

        Client nuevo = Client.builder()
                .firstName(clientDTO.getFirstName())
                .secondName(clientDTO.getSecondName())
                .firstSurname(clientDTO.getFirstSurname())
                .secondSurname(clientDTO.getSecondSurname())
                .documentNumber(clientDTO.getDocumentNumber())
                .password(clientDTO.getPassword())
                .phoneNumber(clientDTO.getPhoneNumber())
                .city(clientDTO.getCity())
                .email(clientDTO.getEmail())
                .role(clientDTO.getRole())
                .build();

        return nuevo;
    }
}
