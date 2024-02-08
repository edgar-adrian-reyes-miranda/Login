package com.logueo.spring.Services;

import com.logueo.spring.Entity.Modalidad;
import com.logueo.spring.Repository.ModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModalidadServices {
    @Autowired
    private ModalidadRepository modalidadRepository;
    
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Modalidad> findAllModalidad(){
        return modalidadRepository.findAll();
    }


}
