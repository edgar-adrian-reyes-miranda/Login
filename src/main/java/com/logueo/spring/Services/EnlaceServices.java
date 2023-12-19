package com.logueo.spring.Services;

import com.logueo.spring.DTO.EnlaceDto;
import com.logueo.spring.Entity.Enlace;
import com.logueo.spring.Repository.EnlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnlaceServices {
    @Autowired
    private EnlaceRepository enlaceRepository;

    //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Enlace> findAllenlace(){
        return enlaceRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Enlace findByIdenlace(Long id) {
        return enlaceRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Enlace crearenlace(EnlaceDto enlaceDto) {
        Enlace enlace= new Enlace ();
        enlace.setTipo_enlace(enlaceDto.getTipo_enlace());
        enlace.setDatosFTDS(enlaceDto.getDatosFTDS());
        return enlaceRepository.save(enlace);
    }

    //Eliminar
    @Transactional
    public void eliminarenlace(Long id) {
        enlaceRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Enlace editarenlace(Long id,EnlaceDto enlaceDto) {
        Enlace enlace= enlaceRepository.findById(id).orElse(null);
        if(enlace != null) {
           enlace.setTipo_enlace(enlaceDto.getTipo_enlace());
           enlace.setDatosFTDS(enlaceDto.getDatosFTDS());
            return enlaceRepository.save(enlace);
        }else {
            return null;
        }
    }
}
