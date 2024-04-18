package com.eam.parcial.servicies;

import com.eam.parcial.dto.OriginDTO;
import com.eam.parcial.models.Origin;

import java.util.List;

public interface OriginService {

    public Origin save(OriginDTO originDTO);

    public Origin findByName(String name);

    public List<Origin> findAll();

    public Origin update(OriginDTO originDTO);

    public Origin factory(OriginDTO originDTO);
}
