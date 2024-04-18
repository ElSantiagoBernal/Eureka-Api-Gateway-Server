package com.eam.parcial.servicies.exceptions;

public class ReservationNotFound extends RuntimeException{

    public ReservationNotFound(String message){
        super(message);
    }
}
