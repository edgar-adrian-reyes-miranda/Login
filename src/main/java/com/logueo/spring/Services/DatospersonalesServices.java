package com.logueo.spring.Services;


import com.logueo.spring.DTO.DatosPersonalesDto;
import com.logueo.spring.Entity.DatosPersonales;
import com.logueo.spring.Repository.DatosPersonalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DatospersonalesServices {
    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;
    //@Autowired
    //private GeneroRepository generoRepository;
    
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<DatosPersonales> findAllPersonal(){
        return datosPersonalesRepository.findAll();
    }
   
    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public DatosPersonales findByIdDatosPersonales(Long id) {
        DatosPersonales datosPersonales= datosPersonalesRepository.findById(id).orElse(null);
        return  datosPersonales;
    }

    //Crear alumno
    @Transactional
    public DatosPersonales crearDatosPersonales(DatosPersonalesDto DatosPersonalesDto) {
        DatosPersonales DatosPersonaless= new DatosPersonales ();
        DatosPersonaless.setCorreo(DatosPersonalesDto.getCorreo());
        DatosPersonaless.setCurp(DatosPersonalesDto.getCurp());
        DatosPersonaless.setDireccion(DatosPersonalesDto.getDireccion());
        DatosPersonaless.setEdad(DatosPersonalesDto.getEdad());
        DatosPersonaless.setNombre(DatosPersonalesDto.getNombre());
        DatosPersonaless.setP_apellido(DatosPersonalesDto.getP_apellido());
        DatosPersonaless.setS_apellido(DatosPersonalesDto.getS_apellido());
        DatosPersonaless.setTelefono(DatosPersonalesDto.getTelefono());
        DatosPersonaless.setTelefono_casa(DatosPersonalesDto.getTelefono_casa());
        /*Genero genero = DatosPersonalesDto.getGenero();
        if(genero != null) {
        	Long generoId= genero.getId_genero();
        	Genero generorecuperado= generoRepository.findById(generoId).orElse(null);
        	DatosPersonaless.setGenero(generorecuperado);
        }*/
        DatosPersonaless.setGenero(DatosPersonalesDto.getGenero());
        DatosPersonaless.setEstados(DatosPersonalesDto.getEstados());
        DatosPersonaless.setMunicipio(DatosPersonalesDto.getMunicipio());
        DatosPersonaless.setDatosEscolares(DatosPersonalesDto.getEscolares());
        DatosPersonaless.setDatosIngresos(DatosPersonalesDto.getIngresos());
        DatosPersonaless.setDatosFTDs(DatosPersonalesDto.getDatosFTDs());
        return datosPersonalesRepository.save(DatosPersonaless);
    }

    //Eliminar
    @Transactional
    public void eliminarDatosPersonales(Long id) {
        datosPersonalesRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public DatosPersonales editarDatosPersonales(Long id, DatosPersonalesDto DatosPersonalesDto) {
        DatosPersonales DatosPersonales = datosPersonalesRepository.findById(id).orElse(null);
        if(DatosPersonales != null) {
          DatosPersonales.setCorreo(DatosPersonalesDto.getCorreo());
          DatosPersonales.setCurp(DatosPersonalesDto.getCurp());
          DatosPersonales.setDireccion(DatosPersonalesDto.getDireccion());
          DatosPersonales.setEdad(DatosPersonalesDto.getEdad());
          DatosPersonales.setNombre(DatosPersonalesDto.getNombre());
          DatosPersonales.setP_apellido(DatosPersonalesDto.getP_apellido());
          DatosPersonales.setS_apellido(DatosPersonalesDto.getS_apellido());
          DatosPersonales.setTelefono(DatosPersonalesDto.getTelefono());
          DatosPersonales.setTelefono_casa(DatosPersonalesDto.getTelefono_casa());
          DatosPersonales.setGenero(DatosPersonalesDto.getGenero());
          /*
          Genero genero = DatosPersonalesDto.getGenero();
          if (genero != null) {
              Long generoId = genero.getId_genero(); 
              Genero generoRecuperado = generoRepository.findById(generoId).orElse(null);
              DatosPersonales.setGenero(generoRecuperado);
          } else {
              DatosPersonales.setGenero(null); 
          }*/
          
          DatosPersonales.setMunicipio(DatosPersonalesDto.getMunicipio());
          DatosPersonales.setEstados(DatosPersonalesDto.getEstados());
          DatosPersonales.setDatosFTDs(DatosPersonalesDto.getDatosFTDs());
          DatosPersonales.setDatosIngresos(DatosPersonalesDto.getIngresos());
          DatosPersonales.setDatosEscolares(DatosPersonalesDto.getEscolares());
            return datosPersonalesRepository.save(DatosPersonales);
        }else {
            return null;
        }
    }
}
