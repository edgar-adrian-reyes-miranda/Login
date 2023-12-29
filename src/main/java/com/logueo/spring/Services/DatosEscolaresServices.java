package com.logueo.spring.Services;

import com.logueo.spring.DTO.DatosEscolaresDto;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Repository.DatosEscolaresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatosEscolaresServices {
    @Autowired
    private DatosEscolaresRepository datosEscolaresRepository;

      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<DatosEscolares> findAllEscolares(){
        return datosEscolaresRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public DatosEscolares findByIdDatosEscolares(Long id) {
        return datosEscolaresRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public DatosEscolares crearDatosEscolares(DatosEscolaresDto DatosEscolaresDto) {
        DatosEscolares DatosEscolaress= new DatosEscolares ();
        DatosEscolaress.setCorreo_inst(DatosEscolaresDto.getCorreo_inst());
        DatosEscolaress.setMatricula(DatosEscolaresDto.getMatricula());
        DatosEscolaress.setCarrera(DatosEscolaresDto.getCarrera());
        return datosEscolaresRepository.save(DatosEscolaress);
    }

    //Eliminar
    @Transactional
    public void eliminarDatosEscolares(Long id) {
        datosEscolaresRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public DatosEscolares editarDatosEscolares(Long id, DatosEscolaresDto DatosEscolaresDto) {
        DatosEscolares DatosEscolares = datosEscolaresRepository.findById(id).orElse(null);
        if(DatosEscolares != null) {
          DatosEscolares.setCorreo_inst(DatosEscolaresDto.getCorreo_inst());
          DatosEscolares.setMatricula(DatosEscolaresDto.getMatricula());
          DatosEscolares.setCarrera(DatosEscolaresDto.getCarrera());
            return datosEscolaresRepository.save(DatosEscolares);
        }else {
            return null;
        }
    }
}
