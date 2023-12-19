package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.ProyectosDto;
import com.logueo.spring.Entity.Proyectos;
import com.logueo.spring.Entity.Unidad;
import com.logueo.spring.Services.ProyectosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/proyectos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProyectosController {

    @Autowired
    private ProyectosServices proyectosServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Proyectos> obtenertodos(){
        return proyectosServices.findAllproyectos();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarproyectosPorID(@PathVariable Long id){
        Proyectos proyectos = null;
        String response = "";
        try {
            proyectos= proyectosServices.findByIdproyectos(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (proyectos == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Proyectos>(proyectos, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearproyecto(@RequestBody ProyectosDto proyectosDto) {
        Proyectos proyectosNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            proyectosNuevo = this.proyectosServices.crearproyecto(proyectosDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + proyectosNuevo.getId_proyecto());
        response.put("Proyecto", proyectosNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarproyectos(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Proyectos proyectosDelete = this.proyectosServices.findByIdproyectos(id);
            if (proyectosDelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            proyectosServices.eliminarproyecto(id);
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
    public ResponseEntity<?> editarAlumnos(@PathVariable Long id, @RequestBody ProyectosDto proyectosDto) {
        Proyectos proyectosditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            proyectosditar = this.proyectosServices.editarproyecto(id, proyectosDto);
            if (proyectosditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("proyecto", proyectosditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
