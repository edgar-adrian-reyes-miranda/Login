package com.logueo.spring.Services;

import com.logueo.spring.DTO.TurnoDto;
import com.logueo.spring.Entity.Turno;
import com.logueo.spring.Repository.TurnoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TurnoServices {
    @Autowired
    private TurnoRepository turnoRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Turno> findAllTurno(){
        return turnoRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Turno findByIdTurno(Long id) {
        return turnoRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Turno crearTurno(TurnoDto TurnoDto) {
        Turno Turnos= new Turno ();
        Turnos.setTipo_turno(TurnoDto.getTipo_turno());
        return turnoRepository.save(Turnos);
    }

    //Eliminar
    @Transactional
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Turno editarTurno(Long id, TurnoDto TurnoDto) {
        Turno Turno = turnoRepository.findById(id).orElse(null);
        if(Turno != null) {
          Turno.setTipo_turno(TurnoDto.getTipo_turno());
            return turnoRepository.save(Turno);
        }else {
            return null;
        }
    }

}
