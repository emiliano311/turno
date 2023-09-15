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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {

    @Autowired
    private TurnoServiceImpl turnoService;


    @GetMapping
    public ResponseEntity<List<TurnoDto>> getAllTurnos(){
        List<Turno> turnos = turnoService.findAll();
        turnoService.crearTurno(new Turno());
        //transformo la lista de turnos a turnosdto
        List<TurnoDto> turnoDtos = turnos.stream().map( turno -> ModelMapperHelper.getModelMapper().map(turno,TurnoDto.class)).collect(Collectors.toList());

        return new ResponseEntity<>(turnoDtos, HttpStatus.OK);
    }


}
