package com.logueo.spring.Services;

import com.logueo.spring.DTO.GruposDto;
import com.logueo.spring.Entity.Grupos;
import com.logueo.spring.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GrupoServices {
    @Autowired
    private GrupoRepository grupoRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Grupos> findAllGrupo(){
        return grupoRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Grupos findByIdGrupos(Long id) {
        return grupoRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Grupos crearGrupos(GruposDto gruposDto) {
        Grupos grupo= new Grupos ();
        grupo.setNombre(gruposDto.getNombre());
        return grupoRepository.save(grupo);
    }

    //Eliminar
    @Transactional
    public void eliminarGrupos(Long id) {
        grupoRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Grupos editarGrupos(Long id, GruposDto gruposDto) {
        Grupos grupo = grupoRepository.findById(id).orElse(null);
        if(grupo != null) {
          grupo.setNombre(gruposDto.getNombre());
            return grupoRepository.save(grupo);
        }else {
            return null;
        }
    }
}
