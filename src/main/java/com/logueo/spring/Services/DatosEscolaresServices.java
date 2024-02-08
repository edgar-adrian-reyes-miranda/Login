package com.logueo.spring.Services;

import com.logueo.spring.DTO.DatosEscolaresDto;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Repository.DatosEscolaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        DatosEscolaress.setPeriodo(DatosEscolaresDto.getPeriodo());
        DatosEscolaress.setUniversidades(DatosEscolaresDto.getUniversidades());
        DatosEscolaress.setPlanEducativo(DatosEscolaresDto.getPlanEducativo());
        DatosEscolaress.setModalidadesEscolares(DatosEscolaresDto.getModalidadesEscolares());
        DatosEscolaress.setDatosPersonales(DatosEscolaresDto.getDatosPersonales());
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
          DatosEscolares.setPeriodo(DatosEscolaresDto.getPeriodo());
          DatosEscolares.setUniversidades(DatosEscolaresDto.getUniversidades());
          DatosEscolares.setPlanEducativo(DatosEscolaresDto.getPlanEducativo());
          DatosEscolares.setModalidadesEscolares(DatosEscolaresDto.getModalidadesEscolares());
          DatosEscolares.setDatosPersonales(DatosEscolaresDto.getDatosPersonales());
            return datosEscolaresRepository.save(DatosEscolares);
        }else {
            return null;
        }
    }
}
