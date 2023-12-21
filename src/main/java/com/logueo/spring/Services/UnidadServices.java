package com.logueo.spring.Services;

import com.logueo.spring.DTO.UnidadDto;
import com.logueo.spring.Repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UnidadServices {
    @Autowired
    private UnidadRepository unidadRepository;

    //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Unidad> findAllunidad(){
        return unidadRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Unidad findByIdAlumno(Long id) {
        return unidadRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Unidad crearunidad(UnidadDto unidadDto) {
        Unidad unidad = new Unidad ();
        unidad.setNombre(unidadDto.getNombre());
        unidad.setCursos(unidadDto.getCursos());
        return unidadRepository.save(unidad);
    }

    //Eliminar
    @Transactional
    public void eliminarunidad(Long id) {
        unidadRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Unidad editarunidad(Long id, UnidadDto unidadDto) {
         Unidad unidad = unidadRepository.findById(id).orElse(null);
        if(unidad != null) {
           unidad.setCursos(unidadDto.getCursos());
           unidad.setNombre(unidadDto.getNombre());
            return unidadRepository.save(unidad);
        }else {
            return null;
        }
    }

}
