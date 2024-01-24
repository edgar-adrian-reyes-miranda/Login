package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.CursosDto;
import com.logueo.spring.Entity.Cursos;
import com.logueo.spring.Services.CursosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CursosController {
    @Autowired
    private CursosServices cursosServices;

  //mapeo para obtenes la lista
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Cursos> ObtenerCursos(){
        return cursosServices.findAllCurso();
    }

  //consulta por id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultaporIdCurso(@PathVariable Long id){
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
            response = "El curso con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cursos>(curso, HttpStatus.OK);
    }

  //guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> CrearCurso(@RequestBody CursosDto cursosDto) {
        Cursos  cursoNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cursoNuevo= this.cursosServices.crearCurso(cursosDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El curso fue creado con éxito, con el ID: " + cursoNuevo.getId_curso());
        response.put("Curso", cursoNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

  //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarCurso(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Cursos becadelete= this.cursosServices.findByIdcurso(id);
            if (becadelete == null) {
                response.put("mensaje", "Error al eliminar. El curso no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            cursosServices.eliminarCurso(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El curso fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

  //Editar
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> EditarCurso(@PathVariable Long id, @RequestBody CursosDto cursosDto) {
        Cursos cursoEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cursoEditar= this.cursosServices.editarCurso(id, cursosDto);
            if (cursoEditar == null) {
                response.put("mensaje", "Error al editar. El curso no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "EL curso actualizado con éxito, con el ID: " + id);
        response.put("Curso", cursoEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
