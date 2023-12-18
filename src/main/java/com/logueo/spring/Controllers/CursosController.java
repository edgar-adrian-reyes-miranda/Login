package com.logueo.spring.Controllers;


import com.logueo.spring.DTO.CursosDto;
import com.logueo.spring.Entity.Cursos;
import com.logueo.spring.Services.CursosServices;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CursosController {
    @Autowired
    private CursosServices cursosServices;
    //litas
    @GetMapping(path = "/lista")
    public List<Cursos> obtenertodos(){
        return cursosServices.findAllcurso();
    }
    //por id
    @GetMapping(path = "{id}")
    public ResponseEntity<?> obtenerporid(@PathVariable Long id){
        Cursos cursos = null;
        String response="";
        try {
            cursos= cursosServices.findByCurso(id);
        }catch (Exception e) {
            response= "Error al obtener consulta: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cursos == null){
            response = "EL alumno con el id:".concat(id.toString()).concat("No se encuentra");
            return  new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cursos>(cursos, HttpStatus.OK);
    }
    @PostMapping(path = "guardar")
    public ResponseEntity<?>crearcurso(@RequestBody CursosDto cursosDto){
        Cursos cursosnuevo= null;
        Map<String, Object> response = new HashMap<>();
            try {
        cursosnuevo= this.cursosServices.crearcurso(cursosDto);
            }catch (Exception e){
        response.put("mensaje", "Error al realziar el insert");
        response.put("error", e.getMessage().concat(e.getLocalizedMessage()));
        return  new ResponseEntity<Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        response.put("mensaje", "Curso creado con exito"+ cursosnuevo.getId_curso());
        response.put("Curso", cursosnuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarcurso(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Cursos cursoDelete = this.cursosServices.findByCurso(id);
            if (cursoDelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            cursosServices.eliminarcurso(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El alumno fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<?> editarcurso(@PathVariable Long id, @RequestBody CursosDto cursosDto) {
        Cursos cursoEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cursoEditar = this.cursosServices.editarcurso(id, cursosDto);
            if (cursoEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "curso actualizado con éxito, con el ID: " + id);
        response.put("curso", cursoEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
