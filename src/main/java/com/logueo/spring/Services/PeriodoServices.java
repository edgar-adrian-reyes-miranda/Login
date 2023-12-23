package com.logueo.spring.Services;

import com.logueo.spring.DTO.PeriodoDto;
import com.logueo.spring.Entity.Periodo;
import com.logueo.spring.Repository.PeriodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeriodoServices {
    @Autowired
    private PeriodoRepository periodoRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Periodo> findAllPeriodo(){
        return periodoRepository.findAll();
    }

}
