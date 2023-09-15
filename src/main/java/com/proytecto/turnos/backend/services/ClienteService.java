package com.proytecto.turnos.backend.services;

import com.proytecto.turnos.backend.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public Cliente nuevoCLiente(Cliente cliente);
    public void borrarCliente(Cliente cliente);
    public Cliente modificarCliente(Cliente cliente);

}
