package com.proytecto.turnos.backend.services;

import com.proytecto.turnos.backend.entities.Cliente;
import com.proytecto.turnos.backend.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    public ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente nuevoCLiente(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Override
    public void borrarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
