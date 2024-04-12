package com.eam.flights.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Response<T> {

    private String mensaje;
    private T dato;

    public Response(String mensaje) {
        this.mensaje = mensaje;
    }

}

