package com.eam.users.services;

import com.eam.users.dto.ClientDTO;
import com.eam.users.dto.PhoneNumberDTO;
import com.eam.users.models.Client;
import com.eam.users.models.PhoneNumber;

import java.util.List;

public interface ClientService {
    public Client save(ClientDTO clientDTO);

    public List<Client> findAll();

    public ClientDTO findByDocumentNumber(String documentNumber);

    public Client update(ClientDTO clientDTO);

    public Client factory(ClientDTO clientDTO);
}
