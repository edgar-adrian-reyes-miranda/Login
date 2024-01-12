package com.logueo.spring.Services;

import com.logueo.spring.Entity.PlanEducativo;
import com.logueo.spring.Repository.PlanEstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanEducativoServices {
    @Autowired
    private PlanEstudiosRepository planEstudiosRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<PlanEducativo> findAllPlanes(){
        return planEstudiosRepository.findAll();
    }


}
