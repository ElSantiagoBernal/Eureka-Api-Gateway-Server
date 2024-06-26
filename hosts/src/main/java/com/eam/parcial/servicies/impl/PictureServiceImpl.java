package com.eam.parcial.servicies.impl;

import com.eam.parcial.dto.PictureDTO;
import com.eam.parcial.models.Picture;
import com.eam.parcial.reposotories.PictureRepository;
import com.eam.parcial.servicies.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {

    @Autowired
    private final PictureRepository pictureRepository;

    @Override
    public Picture save(PictureDTO pictureDTO){
        return pictureRepository.save(factory(pictureDTO));
    }

    @Override
    public List<Picture> findAll(){
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(Integer id){
        return pictureRepository.findById(Long.valueOf(id)).orElse(null);
    }


    @Override
    public Picture update(PictureDTO pictureDTO){
        return pictureRepository.save( factory(pictureDTO) );
    }

    @Override
    public Picture factory(PictureDTO pictureDTO){
        Picture nuevo = Picture.builder()
                .name(pictureDTO.getName())
                .path(pictureDTO.getPath())
                .build();

        return nuevo;
    }
}
