package com.logueo.spring.Services;

import com.logueo.spring.DTO.DatosFTDDto;
import com.logueo.spring.Entity.DatosFTD;
import com.logueo.spring.Repository.DatosFTDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DatoFTDServices {
    @Autowired
    private DatosFTDRepository datosFTDRepository;
    
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<DatosFTD> findAllFTD(){
        return datosFTDRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public DatosFTD findByIdDatosFTD(Long id) {
        return datosFTDRepository.findById(id).orElse(null);
    }

    //Crear ftd
    @Transactional
    public DatosFTD crearDatosFTD(DatosFTDDto DatosFTDDto) {
        DatosFTD DatosFTDs= new DatosFTD ();
        DatosFTDs.setArea(DatosFTDDto.getArea());
        DatosFTDs.setFecha_ingreso(DatosFTDDto.getFecha_ingreso());
        DatosFTDs.setFecha_termino(DatosFTDDto.getFecha_termino());
        DatosFTDs.setMatricula_ftd(DatosFTDDto.getMatricula_ftd());
        DatosFTDs.setCorreo_becario(DatosFTDDto.getCorreo_becario());
        DatosFTDs.setBeca(DatosFTDDto.getBeca());
        DatosFTDs.setBecadocumenot(DatosFTDDto.getBecadocumenot());
        DatosFTDs.setCursos(DatosFTDDto.getCursos());
        DatosFTDs.setEstatusInfotec(DatosFTDDto.getEstatusInfotec());
        DatosFTDs.setEnlace(DatosFTDDto.getEnlace());
        DatosFTDs.setGrupos(DatosFTDDto.getGrupos());
        DatosFTDs.setTutores(DatosFTDDto.getTutores());
        DatosFTDs.setProyectos(DatosFTDDto.getProyectos());
        DatosFTDs.setDatosPersonales(DatosFTDDto.getDatosPersonales());
        return datosFTDRepository.save(DatosFTDs);
    }

    //Eliminar
    @Transactional
    public void eliminarDatosFTD(Long id) {
        datosFTDRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public DatosFTD editarDatosFTD(Long id, DatosFTDDto DatosFTDDto) {
        DatosFTD DatosFTD = datosFTDRepository.findById(id).orElse(null);
        if(DatosFTD != null) {
          DatosFTD.setArea(DatosFTDDto.getArea());
          DatosFTD.setCorreo_becario(DatosFTDDto.getCorreo_becario());
          DatosFTD.setFecha_ingreso(DatosFTDDto.getFecha_ingreso());
          DatosFTD.setFecha_termino(DatosFTDDto.getFecha_termino());
          DatosFTD.setMatricula_ftd(DatosFTDDto.getMatricula_ftd());
          DatosFTD.setEstatusInfotec(DatosFTDDto.getEstatusInfotec());
          DatosFTD.setDatosPersonales(DatosFTDDto.getDatosPersonales());
          DatosFTD.setCursos(DatosFTDDto.getCursos());
          DatosFTD.setEnlace(DatosFTDDto.getEnlace());
          DatosFTD.setGrupos(DatosFTDDto.getGrupos());
          DatosFTD.setTutores(DatosFTDDto.getTutores());
          DatosFTD.setBeca(DatosFTDDto.getBeca());
          DatosFTD.setBecadocumenot(DatosFTDDto.getBecadocumenot());
          DatosFTD.setProyectos(DatosFTDDto.getProyectos());
            return datosFTDRepository.save(DatosFTD);
        }else {
            return null;
        }
    }
}
