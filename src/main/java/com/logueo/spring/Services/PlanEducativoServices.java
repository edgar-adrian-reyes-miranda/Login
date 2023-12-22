package com.logueo.spring.Services;

import com.logueo.spring.DTO.PlanEducativoDto;
import com.logueo.spring.Entity.PlanEducativo;
import com.logueo.spring.Repository.PlanEstudiosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanEducativoServices {
    @Autowired
    private PlanEstudiosRepository planEstudiosRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<PlanEducativo> findAllPlanes(){
        return planEstudiosRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public PlanEducativo findByIdPlanEducativo(Long id) {
        return planEstudiosRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public PlanEducativo crearPlanEducativo(PlanEducativoDto PlanEducativoDto) {
        PlanEducativo PlanEducativos= new PlanEducativo ();
        PlanEducativos.setNombre(PlanEducativoDto.getNombre());
        return planEstudiosRepository.save(PlanEducativos);
    }

    //Eliminar
    @Transactional
    public void eliminarPlanEducativo(Long id) {
        planEstudiosRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public PlanEducativo editarPlanEducativo(Long id, PlanEducativoDto PlanEducativoDto) {
        PlanEducativo PlanEducativo = planEstudiosRepository.findById(id).orElse(null);
        if(PlanEducativo != null) {
          PlanEducativo.setNombre(PlanEducativoDto.getNombre());
          return planEstudiosRepository.save(PlanEducativo);
        }else {
            return null;
        }
    }
}
