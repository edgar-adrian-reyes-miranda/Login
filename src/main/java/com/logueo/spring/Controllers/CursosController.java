package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.CursosDto;
import com.logueo.spring.Entity.Cursos;
import com.logueo.spring.Services.CursosServices;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CursosController {
    @Autowired
    private CursosServices cursosServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Cursos> obtenertodos(){
        return cursosServices.findAllCurso();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        Cursos curso= null;
        String response = "";
        try {
            curso =  cursosServices.findByIdcurso(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (curso == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cursos>(curso, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody CursosDto becaDto) {
        Cursos  cursoNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cursoNuevo= this.cursosServices.crearCurso(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + cursoNuevo.getId_curso());
        response.put("beca", cursoNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Cursos becadelete= this.cursosServices.findByIdcurso(id);
            if (becadelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            cursosServices.eliminarCurso(id);
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
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody CursosDto becaDto) {
        Cursos cursoEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cursoEditar= this.cursosServices.editarCurso(id, becaDto);
            if (cursoEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Beca", cursoEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
