package com.logueo.spring.Services;

import com.logueo.spring.DTO.ModalidadDto;
import com.logueo.spring.Entity.Modalidad;
import com.logueo.spring.Repository.ModalidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModalidadServices {
    @Autowired
    private ModalidadRepository modalidadRepository;
    
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Modalidad> findAllModalidad(){
        return modalidadRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Modalidad findByIdModalidad(Long id) {
        return modalidadRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Modalidad crearModalidad(ModalidadDto ModalidadDto) {
        Modalidad Modalidads= new Modalidad ();
        Modalidads.setTipo_modalidad(ModalidadDto.getTipo_modalidad());
        return modalidadRepository.save(Modalidads);
    }

    //Eliminar
    @Transactional
    public void eliminarModalidad(Long id) {
        modalidadRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Modalidad editarModalidad(Long id, ModalidadDto ModalidadDto) {
        Modalidad Modalidad = modalidadRepository.findById(id).orElse(null);
        if(Modalidad != null) {
          Modalidad.setTipo_modalidad(ModalidadDto.getTipo_modalidad());
            return modalidadRepository.save(Modalidad);
        }else {
            return null;
        }
    }
}
