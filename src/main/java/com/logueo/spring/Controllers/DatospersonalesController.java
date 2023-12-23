package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosPersonalesDto;
import com.logueo.spring.Entity.DatosPersonales;
import com.logueo.spring.Services.DatosEscolaresServices;
import com.logueo.spring.Services.DatospersonalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;

@RestController
@RequestMapping("/api/personales")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatospersonalesController {
    @Autowired
    private DatospersonalesServices datospersonalesServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<DatosPersonales> obtenertodos(){
        return datospersonalesServices.findAllPersonal();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        DatosPersonales personal= null;
        String response = "";
        try {
            personal= datospersonalesServices.findByIdDatosPersonales(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (personal == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosPersonales>(personal, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody DatosPersonalesDto becaDto) {
        DatosPersonales  personalNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            personalNuevo= this.datospersonalesServices.crearDatosPersonales(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno creado con éxito, con el ID: " + personalNuevo.getId_person());
        response.put("Dato Personal", personalNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            DatosPersonales personaldelete= this.datospersonalesServices.findByIdDatosPersonales(id);
            if (personaldelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datospersonalesServices.eliminarDatosPersonales(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El alumno fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //mapeo para editar un alumno
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody DatosPersonalesDto becaDto) {
        DatosPersonales personalEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            personalEditar= this.datospersonalesServices.editarDatosPersonales(id, becaDto);
            if (personalEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Datos Personales", personalEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
