package com.proytecto.turnos.backend.controllers;

import com.proytecto.turnos.backend.Dtos.TurnoDto;
import com.proytecto.turnos.backend.entities.Turno;
import com.proytecto.turnos.backend.services.TurnoService;
import com.proytecto.turnos.backend.services.TurnoServiceImpl;
import com.proytecto.turnos.backend.utils.ModelMapperHelper;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {

    @Autowired
    private TurnoServiceImpl turnoService;

    @GetMapping ("/{id}")
    public ResponseEntity<TurnoDto>getById(@PathVariable Long id){

        Optional<Turno> turno = turnoService.findById(id);
        TurnoDto turnoAux = ModelMapperHelper.getModelMapper().map(turno.get(), TurnoDto.class);

        return new ResponseEntity<TurnoDto>(turnoAux, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<TurnoDto>> getAllTurnos(){
        List<Turno> turnos = turnoService.findAll();
        turnoService.crearTurno(new Turno());
        //transformo la lista de turnos a turnosdto
        List<TurnoDto> turnoDtos = turnos.stream().map( turno -> ModelMapperHelper.getModelMapper().map(turno,TurnoDto.class)).collect(Collectors.toList());

        return new ResponseEntity<>(turnoDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TurnoDto>createTurno(@RequestBody TurnoDto turnoDto){

        Turno turno = ModelMapperHelper.getModelMapper().map(turnoDto, Turno.class);
        TurnoDto turnoAux = ModelMapperHelper.getModelMapper().map(turnoService.crearTurno(turno), TurnoDto.class);

        return new ResponseEntity<TurnoDto>(turnoAux, HttpStatus.ACCEPTED);
    }
}
