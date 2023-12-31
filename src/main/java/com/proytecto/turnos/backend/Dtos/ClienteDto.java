package com.proytecto.turnos.backend.Dtos;

import com.proytecto.turnos.backend.entities.Turno;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;


import java.io.Serializable;
import java.util.List;
@Data
public class ClienteDto implements Serializable {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String email;

    private TurnoDto turno;
}
