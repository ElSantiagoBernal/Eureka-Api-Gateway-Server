package com.eam.parcial.servicies;

import com.eam.parcial.dto.PictureDTO;
import com.eam.parcial.dto.ReservationPostDTO;
import com.eam.parcial.models.Picture;
import com.eam.parcial.models.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    public Reservation save(ReservationPostDTO reservationPostDTO);

    public List<Reservation> findByUserId(Integer userId);

    public List<Reservation> findAll();

    public Reservation findById(Integer id);

    public Integer update(Integer reservationId, ReservationPostDTO reservationPostDTO);

    public void validateHost(Integer hostId);

    public void validateUser(Integer userId);

    public void validateFlight(Integer flightId);

}
