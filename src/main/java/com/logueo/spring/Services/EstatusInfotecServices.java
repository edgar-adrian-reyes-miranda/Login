package com.logueo.spring.Services;

import com.logueo.spring.DTO.EstatusInfotecDto;
import com.logueo.spring.Entity.EstatusInfotec;
import com.logueo.spring.Repository.EstatusInfotecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstatusInfotecServices {
    @Autowired
    private EstatusInfotecRepository estatusInfotecRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<EstatusInfotec> findAllEstatusInfotec(){
        return estatusInfotecRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public EstatusInfotec findByIdEstatusInfotec(Long id) {
        return estatusInfotecRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public EstatusInfotec crearEstatusInfotec(EstatusInfotecDto EstatusInfotecDto) {
        EstatusInfotec EstatusInfotecs= new EstatusInfotec ();
        EstatusInfotecs.setTipo_estaus(EstatusInfotecDto.getTipo_estatus());
        return estatusInfotecRepository.save(EstatusInfotecs);
    }

    //Eliminar
    @Transactional
    public void eliminarEstatusInfotec(Long id) {
        estatusInfotecRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public EstatusInfotec editarEstatusInfotec(Long id, EstatusInfotecDto EstatusInfotecDto) {
        EstatusInfotec EstatusInfotec = estatusInfotecRepository.findById(id).orElse(null);
        if(EstatusInfotec != null) {
          EstatusInfotec.setTipo_estaus(EstatusInfotecDto.getTipo_estatus());
            return estatusInfotecRepository.save(EstatusInfotec);
        }else {
            return null;
        }
    }
}

