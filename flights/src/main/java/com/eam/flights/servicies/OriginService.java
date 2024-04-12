package com.eam.flights.servicies;

import com.eam.flights.dto.DestinyDTO;
import com.eam.flights.dto.OriginDTO;
import com.eam.flights.models.Destiny;
import com.eam.flights.models.Origin;

import java.util.List;
import java.util.Optional;

public interface OriginService {

    public Origin save(OriginDTO originDTO);

    public Origin findByName(String name);

    public List<Origin> findAll();

    public Origin update(OriginDTO originDTO);

    public Origin factory(OriginDTO originDTO);
}
