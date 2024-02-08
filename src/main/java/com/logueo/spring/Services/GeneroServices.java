package com.logueo.spring.Services;

import com.logueo.spring.Entity.Genero;
import com.logueo.spring.Repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GeneroServices {
    @Autowired
    private GeneroRepository generoRepository;

    ///obtener todos por lista
    @Transactional(readOnly = true)
    public List<Genero>findAllGenero(){
        return  generoRepository.findAll();
    }
    //consulta por id
    @Transactional(readOnly = true)
    public Genero findByGenero(Long id){
        return generoRepository.findById(id).orElse(null);
    }
}
