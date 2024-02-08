package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.ProyectosDto;
import com.logueo.spring.Entity.Proyectos;
import com.logueo.spring.Repository.ProyectosReposotory;
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
    @Autowired
    private ProyectosReposotory proyectosReposotory;

  //mapeo para obtenes la lista
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Proyectos> obtenertodos(){
        return proyectosServices.findAllProyecto();
    }

  //consulta por id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ConsultaporIdProyecto(@PathVariable Long id){
        Proyectos proyecto= null;
        String response = "";
        try {
            proyecto= proyectosServices.findByIdProyectos(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (proyecto == null) {
            response = "El proyecto con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Proyectos>(proyecto, HttpStatus.OK);
    }

  //guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?>CrearProyecto(@RequestBody ProyectosDto proyectosDto) {
        Proyectos  Nuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            Nuevo= this.proyectosServices.crearProyectos(proyectosDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Proyecto creado con éxito, con el ID: " + Nuevo.getId_proyecto());
        response.put("Proyectos", Nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

  //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?>EliminarProyecto(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Proyectos delete= this.proyectosServices.findByIdProyectos(id);
            if (delete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            proyectosServices.eliminarProyectos(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El proyecto fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

  //Editar
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody ProyectosDto proyectosDto) {
        Proyectos Editar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Editar= this.proyectosServices.editarProyectos(id, proyectosDto);
            if (Editar == null) {
                response.put("mensaje", "Error al editar. El proyecto no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Proyecto actualizado con éxito, con el ID: " + id);
        response.put("Proyectos", Editar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

   ///cambio  de estado
    @DeleteMapping(path = {"/soft/{id}"})
    public void disableProyecto(@PathVariable Long id){
      proyectosReposotory.deleteById(id);  ///puedo meter mas servicios para que sean eliminacion en cascada
    }

}