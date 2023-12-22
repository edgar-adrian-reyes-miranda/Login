package com.logueo.spring.Services;

import com.logueo.spring.DTO.PeriodoDto;
import com.logueo.spring.Entity.Periodo;
import com.logueo.spring.Repository.PeriodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeriodoServices {
    @Autowired
    private PeriodoRepository periodoRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Periodo> findAllPeriodo(){
        return periodoRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Periodo findByIdPeriodo(Long id) {
        return periodoRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Periodo crearPeriodo(PeriodoDto PeriodoDto) {
        Periodo Periodos= new Periodo ();
        Periodos.setTipo_periodo(PeriodoDto.getTipo_periodo());
        return periodoRepository.save(Periodos);
    }

    //Eliminar
    @Transactional
    public void eliminarPeriodo(Long id) {
        periodoRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Periodo editarPeriodo(Long id, PeriodoDto PeriodoDto) {
        Periodo Periodo = periodoRepository.findById(id).orElse(null);
        if(Periodo != null) {
          Periodo.setTipo_periodo(PeriodoDto.getTipo_periodo());
            return periodoRepository.save(Periodo);
        }else {
            return null;
        }
    }
}
