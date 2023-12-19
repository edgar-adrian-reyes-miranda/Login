package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.EnlaceDto;
import com.logueo.spring.DTO.UnidadDto;
import com.logueo.spring.Entity.Enlace;
import com.logueo.spring.Entity.Unidad;
import com.logueo.spring.Services.EnlaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = {"http://localhost:4200"})
public class EnlaceControllers {
    @Autowired
    private EnlaceServices enlaceServices;
    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Enlace> obtenertodos(){
        return enlaceServices.findAllenlace();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarenlacePorID(@PathVariable Long id){
        Enlace enlace = null;
        String response = "";
        try {
            enlace= enlaceServices.findByIdenlace(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (enlace == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Enlace>(enlace, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearenlace(@RequestBody EnlaceDto enlaceDto) {
        Enlace enlacenuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            enlacenuevo = this.enlaceServices.crearenlace(enlaceDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + enlacenuevo.getId_enlace());
        response.put("enlace", enlacenuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarenlace(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Enlace enlace= this.enlaceServices.findByIdenlace(id);
            if (enlace == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            enlaceServices.eliminarenlace(id);
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
    public ResponseEntity<?> editarenlace(@PathVariable Long id, @RequestBody EnlaceDto enlaceDto) {
        Enlace enlaceditar= null;
        Map<String, Object> response = new HashMap<>();

        try {
            enlaceditar = this.enlaceServices.editarenlace(id, enlaceDto);
            if (enlaceditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("unidad", enlaceditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
