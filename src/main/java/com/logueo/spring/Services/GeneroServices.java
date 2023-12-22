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

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Genero findByIdGenero(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Genero crearGenero(GeneroDto generoDto) {
        Genero Generos= new Genero ();
        Generos.setGenero(generoDto.getGenero());
        return generoRepository.save(Generos);
    }

    //Eliminar
    @Transactional
    public void eliminarGenero(Long id) {
        generoRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Genero editarGenero(Long id, GeneroDto GeneroDto) {
        Genero Genero = generoRepository.findById(id).orElse(null);
        if(Genero != null) {
          Genero.setGenero(GeneroDto.getGenero());
            return generoRepository.save(Genero);
        }else {
            return null;
        }
    }
}
