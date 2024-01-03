package com.logueo.spring.Controllers;


import com.logueo.spring.DTO.ModalidadesEscolaresDto;
import com.logueo.spring.Entity.ModalidadesEscolares;
import com.logueo.spring.Services.ModalidadesEscolaresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/modEscolar")
@RestController
public class ModalidadesEscolaresController {
    @Autowired
    private ModalidadesEscolaresServices modalidadesEscolaresServices;
    //mapeo para obtenes la lista de alumnos
    @GetMapping(path = {"/lista"})
    @ResponseStatus(HttpStatus.OK)
    public List<ModalidadesEscolares> obtenertodos(){
        return modalidadesEscolaresServices.findAllmodalidaEscolar();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarEscolarPorID(@PathVariable Long id){
        ModalidadesEscolares escolar= null;
        String response = "";
        try {
            escolar=modalidadesEscolaresServices.findByIdModalidadesEscolares(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (escolar == null) {
            response = "El modalidad escolar con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ModalidadesEscolares>(escolar, HttpStatus.OK);
    }

    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearmodEscolar(@RequestBody ModalidadesEscolaresDto becaDto) {
        ModalidadesEscolares  Nuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Nuevo= this.modalidadesEscolaresServices.crearModalidadesEscolares(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Modalidad Escoalr creada con éxito, con el ID: " + Nuevo.getId_modalidad());
        response.put("Modalidad Escolar", Nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
