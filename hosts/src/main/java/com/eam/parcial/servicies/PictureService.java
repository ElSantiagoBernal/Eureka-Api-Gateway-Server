package com.eam.parcial.servicies;

import com.eam.parcial.dto.PictureDTO;
import com.eam.parcial.models.Picture;

import java.util.List;

public interface PictureService {


    public Picture save(PictureDTO pictureDTO);

    public List<Picture> findAll();

    public Picture findById(Integer id);

    public Picture update(PictureDTO pictureDTO);

    public Picture factory(PictureDTO pictureDTO);
}
