package com.logueo.spring.Services;

import com.logueo.spring.DTO.PerfilamientoDto;
import com.logueo.spring.Entity.Perfilamiento;
import com.logueo.spring.Repository.PerfilamientoRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfilamientoServices {
    @Autowired
    private PerfilamientoRepositiry perfilamientoRepositiry;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Perfilamiento> findAllPerfilamiento(){
        return perfilamientoRepositiry.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Perfilamiento findByIdPerfilamiento(Long id) {
        return perfilamientoRepositiry.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Perfilamiento crearPerfilamiento(PerfilamientoDto PerfilamientoDto) {
        Perfilamiento Perfilamientos= new Perfilamiento ();
        Perfilamientos.setNombre(PerfilamientoDto.getNombre());
        return perfilamientoRepositiry.save(Perfilamientos);
    }

    //Eliminar
    @Transactional
    public void eliminarPerfilamiento(Long id) {
        perfilamientoRepositiry.deleteById(id);
    }

    //Editar
    @Transactional
    public Perfilamiento editarPerfilamiento(Long id, PerfilamientoDto PerfilamientoDto) {
        Perfilamiento Perfilamiento = perfilamientoRepositiry.findById(id).orElse(null);
        if(Perfilamiento != null) {
          Perfilamiento.setNombre(PerfilamientoDto.getNombre());
            return perfilamientoRepositiry.save(Perfilamiento);
        }else {
            return null;
        }
    }
/*
    public void cambiarestadoperfil(Long id, boolean activo){
        Perfilamiento perfilamiento= perfilamientoRepositiry.findById(id).orElseThrow(()-> new EntityNotFoundException("Perfil no encontrado"));
        perfilamiento.setActivo(activo);
        perfilamientoRepositiry.save(perfilamiento);
    }
*/
}
