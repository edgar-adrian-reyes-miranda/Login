package com.logueo.spring.Services;

import com.logueo.spring.DTO.CursosDto;
import com.logueo.spring.Repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CursosServices {
    @Autowired
    private CursosRepository cursosRepository;

    //obtener todo
    @Transactional(readOnly = true)
    public List<Cursos> findAllcurso(){
        return cursosRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Cursos findByCurso(Long id){
        return cursosRepository.findById(id).orElse(null);
    }

    @Transactional
    public Cursos crearcurso(CursosDto cursosDto){
         Cursos cursos= new Cursos();
         cursos.setNombre(cursosDto.getNombre());
         cursos.setUnidades(cursosDto.getUnidades());
         cursos.setDatosFTDS(cursosDto.getDatosFTDS());
         return cursosRepository.save(cursos);
    }
    @Transactional
    public void eliminarcurso(Long id) {
        cursosRepository.deleteById(id);
    }
        @Transactional
    public Cursos editarcurso(Long id, CursosDto cursodto) {
            Cursos cursos = cursosRepository.findById(id).orElse(null);
            if (cursos != null) {
                cursos.setDatosFTDS(cursodto.getDatosFTDS());
                cursos.setUnidades(cursodto.getUnidades());
                cursos.setNombre(cursodto.getNombre());
                return cursosRepository.save(cursos);
            }else{
                return  null;
            }
    }
}
