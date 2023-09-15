package com.proyecto.turno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.turno.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}