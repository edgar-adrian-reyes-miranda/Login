package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.UniversidadesDto;
import com.logueo.spring.Entity.Universidades;
import com.logueo.spring.Services.UniversidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;

@RestController
@RequestMapping("/api/universidades")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UniversidadesController {
    @Autowired
    private UniversidadServices universidadServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Universidades> obtenertodos(){
        return universidadServices.findAlluniversidad();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        Universidades uni= null;
        String response = "";
        try {
            uni= universidadServices.findByIdUniversidades(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (uni == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Universidades>(uni, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody UniversidadesDto becaDto) {
        Universidades  Nuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Nuevo= this.universidadServices.crearUniversidades(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno creado con éxito, con el ID: " + Nuevo.getId_uni());
        response.put("Universidades", Nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Universidades delete= this.universidadServices.findByIdUniversidades(id);
            if (delete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            universidadServices.eliminarUniversidades(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El alumno fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //mapeo para editar un alumno
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody UniversidadesDto becaDto) {
        Universidades Editar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Editar= this.universidadServices.editarUniversidades(id, becaDto);
            if (Editar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Universidades", Editar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
