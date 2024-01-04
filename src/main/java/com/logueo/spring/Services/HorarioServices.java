package com.logueo.spring.Services;

import com.logueo.spring.Entity.Horarios;
import com.logueo.spring.Repository.HorariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HorarioServices {
    @Autowired
    private HorariosRepository horariosRepository;

      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Horarios> findAllHorario(){
        return horariosRepository.findAll();
    }

}
