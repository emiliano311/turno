package com.proytecto.turnos.backend.repositories;

import com.proytecto.turnos.backend.entities.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnoRepository extends JpaRepository<Turno,Long> {
}
