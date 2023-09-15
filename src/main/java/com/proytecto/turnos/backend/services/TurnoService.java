package com.proytecto.turnos.backend.services;

import com.proytecto.turnos.backend.entities.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {


    public List<Turno> findAll();
    public Turno crearTurno(Turno turno);
    public Optional<Turno> findTurnoById(Long id);
    public Turno modificarTurno(Turno turno);
    public int eliminarTurno(Turno turno);


}
