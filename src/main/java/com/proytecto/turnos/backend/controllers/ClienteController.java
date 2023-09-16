package com.proytecto.turnos.backend.controllers;

import com.proytecto.turnos.backend.Dtos.ClienteDto;
import com.proytecto.turnos.backend.Dtos.TurnoDto;
import com.proytecto.turnos.backend.entities.Cliente;
import com.proytecto.turnos.backend.entities.Turno;
import com.proytecto.turnos.backend.services.ClienteServiceImpl;
import com.proytecto.turnos.backend.services.TurnoServiceImpl;
import com.proytecto.turnos.backend.utils.ModelMapperHelper;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {


    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private TurnoServiceImpl turnoService;
    @GetMapping
    public ResponseEntity<List<ClienteDto>>getAllClientes(){
        ModelMapper modelMapper = new ModelMapper();

        List<Cliente> clentes = clienteService.findAll();
        // Mapear turnos a DTOs
        List<ClienteDto> clientesDto = clentes.stream()
                .map(cliente -> modelMapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());

        return new ResponseEntity<List<ClienteDto>>(clientesDto, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> crearCliente(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = ModelMapperHelper.getModelMapper().map(clienteDto,Cliente.class);
        ClienteDto clienteAux=  ModelMapperHelper.getModelMapper().map(clienteService.nuevoCLiente(cliente),ClienteDto.class);
        return new ResponseEntity<>(clienteAux,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente.get()!= null){
            clienteService.borrarCliente(cliente.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/{id}/turnos")
    public ResponseEntity<TurnoDto> agregarTurno(@PathVariable Long id, @RequestBody TurnoDto turnoDto) {
        // Obtener el cliente
        Optional<Cliente> cliente = clienteService.findById(id);
        if(cliente.isEmpty()){
            return new ResponseEntity<>( new TurnoDto(), HttpStatus.BAD_REQUEST);
        }

        // Crear un nuevo turno
        Turno turno = new Turno();
        turno.setFecha(turnoDto.getFecha());
        turno.setHora(turnoDto.getHora());
        turno.setCliente(cliente.get());
        // Cargar la lista de turnos del cliente


        // Guardar el turno
        turnoService.crearTurno(turno);
        clienteService.modificarCliente(cliente.get());
        ClienteDto clienteDto = ModelMapperHelper.getModelMapper().map(cliente.get(),ClienteDto.class);
        TurnoDto turnoAux = ModelMapperHelper.getModelMapper().map(turnoService.crearTurno(turno),TurnoDto.class);
        turnoAux.setCliente(clienteDto);

      return new ResponseEntity<TurnoDto>(turnoAux, HttpStatus.CREATED);
    }


}
