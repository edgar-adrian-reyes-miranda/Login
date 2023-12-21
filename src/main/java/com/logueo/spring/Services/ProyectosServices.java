package com.logueo.spring.Services;

import com.logueo.spring.DTO.ProyectosDto;
import com.logueo.spring.Repository.ProyectosReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProyectosServices {
    @Autowired
    private ProyectosReposotory proyectosReposotory;

    //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Proyectos> findAllproyectos(){
        return proyectosReposotory.findAll();
    }

    //Consultar proyectos por id
    @Transactional(readOnly = true)
    public Proyectos findByIdproyectos(Long id) {
        return proyectosReposotory.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Proyectos crearproyecto(ProyectosDto proyectosDto) {
        Proyectos proyectos= new Proyectos ();
        proyectos.setAvance(proyectosDto.getAvance());
        proyectos.setNombre(proyectosDto.getNombre());
        proyectos.setEvaluacion(proyectosDto.getEvaluacion());
        proyectos.setDatosFTDS(proyectosDto.getDatosFTDS());
        return proyectosReposotory.save(proyectos);
    }

    //Eliminar
    @Transactional
    public void eliminarproyecto(Long id) {
        proyectosReposotory.deleteById(id);
    }

    //Editar
    @Transactional
    public Proyectos editarproyecto(Long id, ProyectosDto proyectosDto) {
        Proyectos proyectos= proyectosReposotory.findById(id).orElse(null);
        if(proyectos != null) {
           proyectos.setEvaluacion(proyectosDto.getEvaluacion());
           proyectos.setAvance(proyectosDto.getAvance());
           proyectos.setNombre(proyectosDto.getNombre());
           proyectos.setDatosFTDS(proyectosDto.getDatosFTDS());
            return proyectosReposotory.save(proyectos);
        }else {
            return null;
        }
    }
}
