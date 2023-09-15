package com.proytecto.turnos.backend.services;

import com.proytecto.turnos.backend.entities.Turno;
import com.proytecto.turnos.backend.repositories.TurnoRepository;
import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TurnoServiceImpl implements TurnoService{

    @Autowired
    private TurnoRepository turnoRepository;


    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }
    /**
     * @param turno turno
     *              recibe un turno sin id y retorna un turno nuevo
     * @return Turno
     */
    @Override
    public Turno crearTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Optional<Turno> findTurnoById(Long id) {
        Optional turno = turnoRepository.findById(id);
        return turno;
    }

    @Override
    public Turno modificarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public int eliminarTurno(Turno turno) {
        try{
            turnoRepository.delete(turno);
        }catch (HibernateError e){
            return 0;
        }
        return 1;
    }
}
