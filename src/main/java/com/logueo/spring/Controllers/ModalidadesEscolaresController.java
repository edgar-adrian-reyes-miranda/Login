package com.logueo.spring.Controllers;


import com.logueo.spring.Entity.ModalidadesEscolares;
import com.logueo.spring.Services.ModalidadesEscolaresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/modEscolar")
@RestController
public class ModalidadesEscolaresController {
    @Autowired
    private ModalidadesEscolaresServices modalidadesEscolaresServices;
    
  //mapeo para obtenes la lista
    @GetMapping(path = {"/lista"})
    @ResponseStatus(HttpStatus.OK)
    public List<ModalidadesEscolares> obtenertodos(){
        return modalidadesEscolaresServices.findAllmodalidaEscolar();
    }

  //consulta por id
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

}
