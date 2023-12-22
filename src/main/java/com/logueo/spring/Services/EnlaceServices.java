package com.logueo.spring.Services;

import com.logueo.spring.DTO.EnlaceDto;
import com.logueo.spring.Entity.Enlace;
import com.logueo.spring.Repository.EnlaceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnlaceServices {
    @Autowired
    private EnlaceRepository enlaceRepository;

      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Enlace> findAllEnlace(){
        return enlaceRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Enlace findByIdEnlace(Long id) {
        return enlaceRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Enlace crearEnlace(EnlaceDto EnlaceDto) {
        Enlace Enlaces= new Enlace ();
        Enlaces.setTipo_enlace(EnlaceDto.getTipo_enlace());
        return enlaceRepository.save(Enlaces);
    }

    //Eliminar
    @Transactional
    public void eliminarEnlace(Long id) {
        enlaceRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Enlace editarEnlace(Long id, EnlaceDto EnlaceDto) {
        Enlace Enlace = enlaceRepository.findById(id).orElse(null);
        if(Enlace != null) {
          Enlace.setTipo_enlace(EnlaceDto.getTipo_enlace());
            return enlaceRepository.save(Enlace);
        }else {
            return null;
        }
    }
}
