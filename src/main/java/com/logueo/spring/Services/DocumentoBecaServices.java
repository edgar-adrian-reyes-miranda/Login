package com.logueo.spring.Services;

import com.logueo.spring.DTO.DocumentoBecaDto;
import com.logueo.spring.Repository.DocumentoBecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentoBecaServices {
    @Autowired
    private DocumentoBecaRepository documentoBecaRepository;

    //Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<DocumentoBeca> findAlldocumentobeca(){
        return documentoBecaRepository.findAll();
    }

    //Consultar alumnos por id
    @Transactional(readOnly = true)
    public DocumentoBeca findByIddocumentobeca(Long id) {
        return documentoBecaRepository.findById(id).orElse(null);
    }

    //Crear alumno
    @Transactional
    public DocumentoBeca creardocumento(DocumentoBecaDto documentoBecaDto) {
        DocumentoBeca documentoBeca= new DocumentoBeca();
        documentoBeca.setBeca(documentoBecaDto.getBeca());
        documentoBeca.setCuenta(documentoBecaDto.getCuenta());
        documentoBeca.setPago(documentoBecaDto.getPago());

        return documentoBecaRepository.save(documentoBeca);
    }

    //Eliminar
    @Transactional
    public void eliminardocumento(Long id) {
        documentoBecaRepository.deleteById(id);
    }

    //Editar
    @Transactional
    public DocumentoBeca editardocumento(Long id, DocumentoBecaDto documentoBecaDto) {
        DocumentoBeca documentoBeca= documentoBecaRepository.findById(id).orElse(null);
        if(documentoBeca != null) {
            documentoBeca.setPago(documentoBecaDto.getPago());
            documentoBeca.setCuenta(documentoBecaDto.getCuenta());
            documentoBeca.setBeca(documentoBecaDto.getBeca());
            return documentoBecaRepository.save(documentoBeca);
        }else {
            return null;
        }
    }
}
