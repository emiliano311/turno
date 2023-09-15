/**
 * 
 */
package com.proyecto.turno.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.turno.entities.Cliente;

/**
 * @author Emi
 *
 */

@Service
public interface ClienteService {
	
	public List<Cliente> obtenerClientes();
	
    public Cliente crearCliente(Cliente cliente) ;

    public Cliente obtenerClientePorId(Long id) ;

    public Cliente actualizarCliente(Cliente cliente) ;

    public void eliminarCliente(Long id);
}