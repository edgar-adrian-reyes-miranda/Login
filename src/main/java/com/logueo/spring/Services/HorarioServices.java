package com.logueo.spring.Services;

import com.logueo.spring.DTO.HorariosDto;
import com.logueo.spring.Entity.Horarios;
import com.logueo.spring.Repository.HorariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HorarioServices {
    @Autowired
    private HorariosRepository horariosRepository;

      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Horarios> findAllHorario(){
        return horariosRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Horarios findByIdHorarios(Long id) {
        return horariosRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Horarios crearHorarios(HorariosDto HorariosDto) {
        Horarios Horarioss= new Horarios ();
        Horarioss.setHoraio(HorariosDto.getHorario());
        return horariosRepository.save(Horarioss);
    }

    //Eliminar
    @Transactional
    public void eliminarHorarios(Long id) {
        horariosRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Horarios editarHorarios(Long id, HorariosDto HorariosDto) {
        Horarios Horarios = horariosRepository.findById(id).orElse(null);
        if(Horarios != null) {
          Horarios.setHoraio(HorariosDto.getHorario());
            return horariosRepository.save(Horarios);
        }else {
            return null;
        }
    }
}
