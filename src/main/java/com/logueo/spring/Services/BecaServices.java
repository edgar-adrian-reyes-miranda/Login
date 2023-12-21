package com.logueo.spring.Services;

import com.logueo.spring.DTO.BecaDto;
import com.logueo.spring.Repository.BecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BecaServices {
    @Autowired
    private BecaRepository  becaRepository;

    //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Beca> findAllbeca(){
        return becaRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public Beca findByIdbeca(Long id) {
        return becaRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public Beca crearbeca(BecaDto becaDto) {
        Beca becas= new Beca ();
        becas.setDocumentoBecas(becaDto.getDocumentoBecas());
        becas.setNombre_beca(becaDto.getNombre_beca());
        becas.setMonto(becaDto.getMonto());
        becas.setDatosFTDs(becaDto.getDatosFTDs());
        return becaRepository.save(becas);
    }

    //Eliminar
    @Transactional
    public void eliminarbeca(Long id) {
        becaRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public Beca editarbeca(Long id, BecaDto becaDto) {
        Beca beca = becaRepository.findById(id).orElse(null);
        if(beca != null) {
          beca.setDatosFTDs(becaDto.getDatosFTDs());
          beca.setNombre_beca(becaDto.getNombre_beca());
          beca.setMonto(becaDto.getMonto());
          beca.setDocumentoBecas(becaDto.getDocumentoBecas());
            return becaRepository.save(beca);
        }else {
            return null;
        }
    }
}
