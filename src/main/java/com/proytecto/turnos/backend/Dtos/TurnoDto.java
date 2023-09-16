package com.proytecto.turnos.backend.Dtos;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
@Data
public class TurnoDto implements Serializable {

    private Long id;
    private Date fecha;
    private Time hora;
    private String servicio;

    private ClienteDto cliente;
}