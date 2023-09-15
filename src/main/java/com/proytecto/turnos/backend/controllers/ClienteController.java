package com.proytecto.turnos.backend.controllers;

import com.proytecto.turnos.backend.Dtos.ClienteDto;
import com.proytecto.turnos.backend.entities.Cliente;
import com.proytecto.turnos.backend.services.ClienteServiceImpl;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Cliente")
public class ClienteController {


    @Autowired
    private ClienteServiceImpl clienteService;
    @GetMapping
    public ResponseEntity<List<ClienteDto>>getAllClientes(){
        ModelMapper modelMapper = new ModelMapper();

        List<Cliente> clentes = clienteService.findAll();



        // Mapear turnos a DTOs
        List<ClienteDto> clientesDto = clentes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());

        // Verifica si la lista es nula
        if(clientesDto == null){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<ClienteDto>>(clientesDto, HttpStatus.ACCEPTED);
    }



}
