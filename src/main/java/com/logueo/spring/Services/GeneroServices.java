package com.logueo.spring.Services;

import com.logueo.spring.DTO.GeneroDto;
import com.logueo.spring.Entity.Genero;
import com.logueo.spring.Repository.GeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroServices {
    @Autowired
    private GeneroRepository generoRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Genero> findAllgenero(){
        return generoRepository.findAll();
    }
}
