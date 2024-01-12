package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosEscolaresDto;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Services.DatosEscolaresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/escolares")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosEscolaresController {
    @Autowired
    private DatosEscolaresServices datosEscolaresServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<DatosEscolares> obtenertodos(){
        return datosEscolaresServices.findAllEscolares();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        DatosEscolares beca= null;
        String response = "";
        try {
            beca= datosEscolaresServices.findByIdDatosEscolares(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (beca == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosEscolares>(beca, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody DatosEscolaresDto becaDto) {
        DatosEscolares  becaNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            becaNuevo= this.datosEscolaresServices.crearDatosEscolares(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + becaNuevo.getId_escolar());
        response.put("beca", becaNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            DatosEscolares becadelete= this.datosEscolaresServices.findByIdDatosEscolares(id);
            if (becadelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datosEscolaresServices.eliminarDatosEscolares(id);
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
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody DatosEscolaresDto becaDto) {
        DatosEscolares becaEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            becaEditar= this.datosEscolaresServices.editarDatosEscolares(id, becaDto);
            if (becaEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Beca", becaEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
