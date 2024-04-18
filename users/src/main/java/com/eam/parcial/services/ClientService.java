package com.eam.parcial.services;

import com.eam.parcial.dto.ClientDTO;
import com.eam.parcial.models.Client;

import java.util.List;

public interface ClientService {
    public Client save(ClientDTO clientDTO);

    public List<Client> findAll();

    public ClientDTO findByDocumentNumber(String documentNumber);

    public Client update(ClientDTO clientDTO);

    public Client factory(ClientDTO clientDTO);
}
