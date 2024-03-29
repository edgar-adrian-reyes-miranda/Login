package com.logueo.spring.Services;

import com.logueo.spring.DTO.UniversidadesDto;
import com.logueo.spring.Entity.Universidades;
import com.logueo.spring.Repository.UniversidadRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversidadServices {
    @Autowired
    private UniversidadRepository universidadRepository;

    @Autowired
    private EntityManager entityManager;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Universidades> findAlluniversidad(){
        return universidadRepository.findByActivoTrue();
    }

    @Transactional(readOnly = true)
    public List<Universidades> findAllUniversidadesF() {
        return universidadRepository.findByActivoFalse();
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

    public void eliminar(Long id){
        Universidades universidades = universidadRepository.findById(id).orElseThrow();
        universidades.setActivo(false);
        universidadRepository.save(universidades);
    }

    public Universidades restaurar(Long id){
        Universidades universidades = universidadRepository.findById(id).orElseThrow();
        universidades.setActivo(true);
        universidadRepository.save(universidades);
        return universidades;
    }

}
