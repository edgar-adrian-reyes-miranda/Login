package com.logueo.spring.Services;

import com.logueo.spring.DTO.DatosFTDDto;
import com.logueo.spring.Repository.DatosFTDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DatosFtdServices {
    @Autowired
    private DatosFTDRepository datosFTDRepository;

    //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<DatosFTD> findAlldatosftd(){
        return datosFTDRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public DatosFTD findByIddatoftd(Long id) {
        return datosFTDRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public DatosFTD creardatosftd(DatosFTDDto datosFTDDto) {
        DatosFTD datosFTD= new DatosFTD ();
        return getDatosFTD(datosFTDDto, datosFTD);
    }

    //Eliminar
    @Transactional
    public void eliminardatosftd(Long id) {
        datosFTDRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public DatosFTD editardatoftd(Long id, DatosFTDDto datosFTDDto) {
        DatosFTD datosFTD= datosFTDRepository.findById(id).orElse(null);
        if(datosFTD != null) {
            return getDatosFTD(datosFTDDto, datosFTD);
        }else {
            return null;
        }
    }

    private DatosFTD getDatosFTD(DatosFTDDto datosFTDDto, DatosFTD datosFTD) {
        datosFTD.setArea(datosFTDDto.getArea());
        datosFTD.setBeca(datosFTDDto.getBeca());
        datosFTD.setEnlace(datosFTDDto.getEnlace());
        datosFTD.setCursos(datosFTDDto.getCursos());
        datosFTD.setDatospersonales(datosFTDDto.getDatospersonales());
        datosFTD.setGrupo(datosFTDDto.getGrupo());
        datosFTD.setEstausInfotecs(datosFTDDto.getEstausInfotecs());
        datosFTD.setCorreo_becario(datosFTDDto.getCorreo_becario());
        datosFTD.setFecha_final(datosFTDDto.getFecha_final());
        datosFTD.setFecha_inicio(datosFTDDto.getFecha_inicio());
        datosFTD.setProyectos(datosFTDDto.getProyectos());
        datosFTD.setTutor(datosFTD.getTutor());
        datosFTD.setMatricula(datosFTD.getMatricula());
        return datosFTDRepository.save(datosFTD);
    }

}
