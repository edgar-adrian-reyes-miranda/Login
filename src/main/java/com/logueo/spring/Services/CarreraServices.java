package com.logueo.spring.Services;

import com.logueo.spring.DTO.CarrerasDto;
import com.logueo.spring.Entity.Carreras;
import com.logueo.spring.Repository.CarreraRepostory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraServices {
    @Autowired
    private CarreraRepostory carreraRepostory;

      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Carreras> findAllCarrera(){
        return carreraRepostory.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Carreras findByIdCarreras(Long id) {
        return carreraRepostory.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Carreras crearCarreras(CarrerasDto CarrerasDto) {
        Carreras Carrerass= new Carreras ();
        Carrerass.setNombre(CarrerasDto.getNombre());
        return carreraRepostory.save(Carrerass);
    }

    //Eliminar
    @Transactional
    public void eliminarCarreras(Long id) {
        carreraRepostory.deleteById(id);
    }

    //Editar
    @Transactional
    public Carreras editarCarreras(Long id, CarrerasDto CarrerasDto) {
        Carreras Carreras = carreraRepostory.findById(id).orElse(null);
        if(Carreras != null) {
          Carreras.setNombre(CarrerasDto.getNombre());
            return carreraRepostory.save(Carreras);
        }else {
            return null;
        }
    }
}
