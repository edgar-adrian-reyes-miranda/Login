package com.logueo.spring.Services;

import com.logueo.spring.DTO.ModalidadesEscolaresDto;
import com.logueo.spring.Entity.ModalidadesEscolares;
import com.logueo.spring.Repository.ModalidadesEscolaresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModalidadesEscolaresServices {
    @Autowired
    private ModalidadesEscolaresRepository modalidadesEscolaresRepository;

      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<ModalidadesEscolares> findAllmodalidaEscolar(){
        return modalidadesEscolaresRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public ModalidadesEscolares findByIdModalidadesEscolares(Long id) {
        return modalidadesEscolaresRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public ModalidadesEscolares crearModalidadesEscolares(ModalidadesEscolaresDto ModalidadesEscolaresDto) {
        ModalidadesEscolares ModalidadesEscolaress= new ModalidadesEscolares ();
        ModalidadesEscolaress.setTipo_modadlidad(ModalidadesEscolaresDto.getTipo_modalidad());
        return modalidadesEscolaresRepository.save(ModalidadesEscolaress);
    }

    //Eliminar
    @Transactional
    public void eliminarModalidadesEscolares(Long id) {
        modalidadesEscolaresRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public ModalidadesEscolares editarModalidadesEscolares(Long id, ModalidadesEscolaresDto ModalidadesEscolaresDto) {
        ModalidadesEscolares ModalidadesEscolares = modalidadesEscolaresRepository.findById(id).orElse(null);
        if(ModalidadesEscolares != null) {
          ModalidadesEscolares.setTipo_modadlidad(ModalidadesEscolaresDto.getTipo_modalidad());
            return modalidadesEscolaresRepository.save(ModalidadesEscolares);
        }else {
            return null;
        }
    }
}
