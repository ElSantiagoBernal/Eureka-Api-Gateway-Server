package com.eam.parcial.servicies;

import com.eam.parcial.dto.DestinyDTO;
import com.eam.parcial.models.Destiny;

import java.util.List;

public interface DestinyService {

    public Destiny save(DestinyDTO destinyDTO);

    public Destiny findByName(String name);

    public List<Destiny> findAll();

    public Destiny update(DestinyDTO destinyDTO);

    public Destiny factory(DestinyDTO destinyDTO);
}
