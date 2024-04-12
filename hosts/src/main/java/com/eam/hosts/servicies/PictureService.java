package com.eam.hosts.servicies;

import com.eam.hosts.dto.PictureDTO;
import com.eam.hosts.models.Picture;

import java.util.List;

public interface PictureService {


    public Picture save(PictureDTO pictureDTO);

    public List<Picture> findAll();

    public Picture findById(Integer id);

    public Picture update(PictureDTO pictureDTO);

    public Picture factory(PictureDTO pictureDTO);
}
