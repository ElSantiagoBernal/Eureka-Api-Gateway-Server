package com.eam.flights.servicies;

import com.eam.flights.dto.DestinyDTO;
import com.eam.flights.models.Destiny;

import java.util.List;
import java.util.Optional;

public interface DestinyService {

    public Destiny save(DestinyDTO destinyDTO);

    public Destiny findByName(String name);

    public List<Destiny> findAll();

    public Destiny update(DestinyDTO destinyDTO);

    public Destiny factory(DestinyDTO destinyDTO);
}
