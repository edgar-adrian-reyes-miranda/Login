package com.logueo.spring.Services;

import com.logueo.spring.DTO.UniversidadesDto;
import com.logueo.spring.Entity.Universidades;
import com.logueo.spring.Repository.UniversidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UniversidadServices {
    @Autowired
    private UniversidadRepository universidadRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Universidades> findAlluniversidad(){
        return universidadRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Universidades findByIdUniversidades(Long id) {
        return universidadRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Universidades crearUniversidades(UniversidadesDto UniversidadesDto) {
        Universidades Universidadess= new Universidades ();
        Universidadess.setNombre(UniversidadesDto.getNombre());
        return universidadRepository.save(Universidadess);
    }

    //Eliminar
    @Transactional
    public void eliminarUniversidades(Long id) {
        universidadRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Universidades editarUniversidades(Long id, UniversidadesDto UniversidadesDto) {
        Universidades Universidades = universidadRepository.findById(id).orElse(null);
        if(Universidades != null) {
          Universidades.setNombre(UniversidadesDto.getNombre());
            return universidadRepository.save(Universidades);
        }else {
            return null;
        }
    }
}
