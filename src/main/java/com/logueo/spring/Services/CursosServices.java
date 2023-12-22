package com.logueo.spring.Services;

import com.logueo.spring.DTO.CursosDto;
import com.logueo.spring.Entity.Cursos;
import com.logueo.spring.Repository.CursosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursosServices {
    @Autowired
    private CursosRepository cursosRepository;

     //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Cursos> findAllCurso(){
        return cursosRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Cursos findByIdcurso(Long id) {
        return cursosRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Cursos crearCurso(CursosDto cursosDto) {
        Cursos curso= new Cursos();
        curso.setNombre(cursosDto.getNombre());
        curso.setTipo_estatus(cursosDto.getTipo_estatus());
        curso.setUnidad(cursosDto.getUnidad());
        return cursosRepository.save(curso);
    }

    //Eliminar
    @Transactional
    public void eliminarCurso(Long id) {
        cursosRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Cursos editarCurso(Long id,CursosDto cursosDto) {
        Cursos curso = cursosRepository.findById(id).orElse(null);
        if(curso != null) {
          curso.setNombre(cursosDto.getNombre());
          curso.setTipo_estatus(cursosDto.getTipo_estatus());
          curso.setUnidad(cursosDto.getUnidad());
            return cursosRepository.save(curso);
        }else {
            return null;
        }
    }

}
