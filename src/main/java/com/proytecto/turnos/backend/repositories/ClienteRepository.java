package com.proytecto.turnos.backend.repositories;

import com.proytecto.turnos.backend.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
