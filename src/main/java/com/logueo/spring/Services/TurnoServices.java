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

}
