package com.logueo.spring.Services;

import com.logueo.spring.DTO.ProyectosDto;
import com.logueo.spring.Entity.Proyectos;
import com.logueo.spring.Repository.ProyectosReposotory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProyectosServices {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProyectosReposotory proyectosReposotory;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Proyectos> findAllProyecto(){
        return proyectosReposotory.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Proyectos findByIdProyectos(Long id) {
        return proyectosReposotory.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Proyectos crearProyectos(ProyectosDto ProyectosDto) {
        Proyectos Proyectoss= new Proyectos ();
        Proyectoss.setAvance(ProyectosDto.getAvance());
        Proyectoss.setEvaluacion(ProyectosDto.getEvaluacion());
        Proyectoss.setNombre(ProyectosDto.getNombre());
        return proyectosReposotory.save(Proyectoss);
    }

    //Eliminar
    @Transactional
    public void eliminarProyectos(Long id) {
        proyectosReposotory.deleteById(id);
    }

    //Editar
    @Transactional
    public Proyectos editarProyectos(Long id, ProyectosDto ProyectosDto) {
        Proyectos Proyectos = proyectosReposotory.findById(id).orElse(null);
        if(Proyectos != null) {
          Proyectos.setAvance(ProyectosDto.getAvance());
          Proyectos.setEvaluacion(ProyectosDto.getEvaluacion());
          Proyectos.setNombre(ProyectosDto.getNombre());
            return proyectosReposotory.save(Proyectos);
        }else {
            return null;
        }
    }

}
