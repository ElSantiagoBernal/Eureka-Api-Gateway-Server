package com.eam.parcial.servicies.impl;

import com.eam.parcial.dto.Flight;
import com.eam.parcial.dto.ReservationPostDTO;
import com.eam.parcial.dto.Response;
import com.eam.parcial.dto.User;
import com.eam.parcial.models.Host;
import com.eam.parcial.models.Picture;
import com.eam.parcial.models.Reservation;
import com.eam.parcial.reposotories.ReservationRepository;
import com.eam.parcial.servicies.ReservationService;
import com.eam.parcial.servicies.exceptions.ReservationNotFound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final RestTemplate restTemplate;

    private ReservationRepository reservationRepository;

    @Override
    public Reservation save(ReservationPostDTO reservationPostDTO) {
        validateHost(reservationPostDTO.hostId());
        validateFlight(reservationPostDTO.flightId());
        validateUser(reservationPostDTO.userId());

        Reservation reservation = new Reservation();
        reservation.setFlightId(reservationPostDTO.flightId());
        reservation.setHostId(reservationPostDTO.hostId());
        reservation.setUserId(reservationPostDTO.userId());
        reservation.setReservationDate(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findByUserId(Integer userId) {
        validateUser(userId);
        List<Reservation> lista = reservationRepository.findByUserId(userId);

        return new ArrayList<>();
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Integer update(Integer reservationId, ReservationPostDTO reservationPostDTO) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(()-> new ReservationNotFound("No existe una reserva con el código: "+reservationId));

        validateHost(reservationPostDTO.hostId());
        validateFlight(reservationPostDTO.flightId());
        validateUser(reservationPostDTO.userId());

        reservation.setFlightId(reservationPostDTO.flightId());
        reservation.setHostId(reservationPostDTO.hostId());
        reservation.setUserId(reservationPostDTO.userId());
        reservation.setReservationDate(LocalDateTime.now());

        return reservationRepository.save(reservation).getId();
    }

    @Override
    public void validateHost(Integer hostId) {
        ResponseEntity<Response<Host>> responseEntity;
        try {

            responseEntity = restTemplate.exchange(
                    "http://gateway-service:9999/api/host/" + hostId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Response<Host>>() {});

            if(responseEntity.getStatusCode() == HttpStatus.OK){
                Host host = responseEntity.getBody().getDato();
                if(host == null || host.getId() == null){
                    throw new RuntimeException("El código " + hostId + " no pertenece a ningún host");
                }
            }

        }catch (HttpClientErrorException e){
            // Manejar errores específicos del Flight HTTP
            throw new RuntimeException("Error en la solicitud: " + e.getMessage());
        }catch (HttpServerErrorException e){
            // Manejar errores del servidor
            throw new RuntimeException("Error en el servidor: " + e.getMessage());
        }catch (Exception e){
            // Manejar cualquier otra excepción
            e.printStackTrace();
            throw new RuntimeException("Hubo un error recuperando la información del host");
        }
    }

    @Override
    public void validateUser(Integer userId) {
        ResponseEntity<Response<User>> responseEntity;
        try {

            responseEntity = restTemplate.exchange(
                    "http://gateway-service:9999/api/client/" + userId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Response<User>>() {});

            if(responseEntity.getStatusCode() == HttpStatus.OK){
                User user = responseEntity.getBody().getDato();
                if(user == null || user.getId() == null){
                    throw new RuntimeException("El código " + userId + " no pertenece a ningún usuario");
                }
            }

        }catch (HttpClientErrorException e){
            // Manejar errores específicos del Flight HTTP
            throw new RuntimeException("Error en la solicitud: " + e.getMessage());
        }catch (HttpServerErrorException e){
            // Manejar errores del servidor
            throw new RuntimeException("Error en el servidor: " + e.getMessage());
        }catch (Exception e){
            // Manejar cualquier otra excepción
            e.printStackTrace();
            throw new RuntimeException("Hubo un error recuperando la información del user");
        }

    }

    @Override
    public void validateFlight(Integer flightId) {
        ResponseEntity<Response<Flight>> responseEntity;
        try {

            responseEntity = restTemplate.exchange(
                    "http://gateway-service:9999/api/flight/" + flightId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Response<Flight>>() {});

            if(responseEntity.getStatusCode() == HttpStatus.OK){
                Flight flight = responseEntity.getBody().getDato();
                if(flight == null || flight.getId() == null){
                    throw new RuntimeException("El código " + flightId + " no pertenece a ningún flight");
                }
            }

        }catch (HttpClientErrorException e){
            // Manejar errores específicos del Flight HTTP
            throw new RuntimeException("Error en la solicitud: " + e.getMessage());
        }catch (HttpServerErrorException e){
            // Manejar errores del servidor
            throw new RuntimeException("Error en el servidor: " + e.getMessage());
        }catch (Exception e){
            // Manejar cualquier otra excepción
            e.printStackTrace();
            throw new RuntimeException("Hubo un error recuperando la información del Flight");
        }
    }
}
