package com.logueo.spring.Services;

import com.logueo.spring.DTO.DatosPersonalesDto;
import com.logueo.spring.Entity.Datospersonales;
import com.logueo.spring.Repository.DatosFTDRepository;
import com.logueo.spring.Repository.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DatosPersonalesServices {
    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;
    //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Datospersonales> findAlldatospersonales(){
        return datosPersonalesRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Datospersonales findByIddatopersponal(Long id) {
        return datosPersonalesRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Datospersonales creardatopersonal(DatosPersonalesDto datosPersonalesDto) {
        Datospersonales datospersonales= new Datospersonales ();
        datospersonales.setNombre(datosPersonalesDto.getNombre());
        datospersonales.setDatosFTDs(datosPersonalesDto.getDatosFTDs());
        datospersonales.setCurp(datospersonales.getCurp());
        datospersonales.setUsuario(datosPersonalesDto.getUsuario());
        datospersonales.setGenero(datosPersonalesDto.getGenero());
        datospersonales.setTelefono(datosPersonalesDto.getTelefono());
        datospersonales.setTelefonocasa(datosPersonalesDto.getTelefonocasa());
        datospersonales.setP_apellido(datosPersonalesDto.getP_apellido());
        datospersonales.setS_apellido(datosPersonalesDto.getS_apellido());
        return datosPersonalesRepository.save(datospersonales);
    }

    //Eliminar
    @Transactional
    public void eliminardatopersponal(Long id) {
        datosPersonalesRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Datospersonales editardatopersonal(Long id,DatosPersonalesDto datosPersonalesDto) {
        Datospersonales datospersonales= datosPersonalesRepository.findById(id).orElse(null);
        if(datospersonales != null) {
            datospersonales.setS_apellido(datosPersonalesDto.getS_apellido());
            datospersonales.setGenero(datosPersonalesDto.getGenero());
            datospersonales.setCurp(datosPersonalesDto.getCurp());
            datospersonales.setTelefonocasa(datosPersonalesDto.getTelefonocasa());
            datospersonales.setTelefono(datosPersonalesDto.getTelefono());
            datospersonales.setUsuario(datosPersonalesDto.getUsuario());
            datospersonales.setDatosFTDs(datosPersonalesDto.getDatosFTDs());
            datospersonales.setNombre(datosPersonalesDto.getNombre());
            datospersonales.setP_apellido(datosPersonalesDto.getP_apellido());
            return datosPersonalesRepository.save(datospersonales);
        }else {
            return null;
        }
    }
}
