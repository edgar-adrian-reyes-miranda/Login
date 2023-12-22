package com.logueo.spring.Services;

import com.logueo.spring.DTO.TramiteDto;
import com.logueo.spring.Entity.Tramite;
import com.logueo.spring.Repository.TramiteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TramiteServices {
    @Autowired
    private TramiteRepository tramiteRepository;
      //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Tramite> findAllTramite(){
        return tramiteRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Tramite findByIdTramite(Long id) {
        return tramiteRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Tramite crearTramite(TramiteDto TramiteDto) {
        Tramite Tramites= new Tramite ();
        Tramites.setTipo_tramite(TramiteDto.getTipo_tramite());
        return tramiteRepository.save(Tramites);
    }

    //Eliminar
    @Transactional
    public void eliminarTramite(Long id) {
        tramiteRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Tramite editarTramite(Long id, TramiteDto TramiteDto) {
        Tramite Tramite = tramiteRepository.findById(id).orElse(null);
        if(Tramite != null) {
          Tramite.setTipo_tramite(TramiteDto.getTipo_tramite());
            return tramiteRepository.save(Tramite);
        }else {
            return null;
        }
    }
}
