package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.CarrerasDto;
import com.logueo.spring.Entity.Carreras;
import com.logueo.spring.Services.CarreraServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/carrera")
@CrossOrigin(origins = {"http://localhost:4200"})
public class CarrerasController {
    @Autowired
    private CarreraServices carreraServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Carreras> obtenertodos(){
        return carreraServices.findAllCarrera();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        Carreras carreras= null;
        String response = "";
        try {
            carreras= carreraServices.findByIdCarreras(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (carreras == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Carreras>(carreras, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody CarrerasDto becaDto) {
        Carreras  carreraNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            carreraNuevo= this.carreraServices.crearCarreras(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + carreraNuevo.getId_carrera());
        response.put("beca", carreraNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Carreras carreradelete= this.carreraServices.findByIdCarreras(id);
            if (carreradelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            carreraServices.eliminarCarreras(id);
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
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody CarrerasDto becaDto) {
        Carreras carreraEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            carreraEditar= this.carreraServices.editarCarreras(id, becaDto);
            if (carreraEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Beca", carreraEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
