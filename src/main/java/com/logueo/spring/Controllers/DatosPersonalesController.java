package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosPersonalesDto;
import com.logueo.spring.Entity.Datospersonales;
import com.logueo.spring.Services.DatosPersonalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/datospersonales")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosPersonalesController {
    @Autowired
    private DatosPersonalesServices datosPersonalesServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Datospersonales> obtenertodos(){
        return datosPersonalesServices.findAlldatospersonales();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultardatopersonalPorID(@PathVariable Long id){
        Datospersonales datospersonales = null;
        String response = "";
        try {
            datospersonales=this.datosPersonalesServices.findByIddatopersponal(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (datospersonales == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Datospersonales>(datospersonales, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> creardatopersonal(@RequestBody DatosPersonalesDto datosPersonalesDto) {
        Datospersonales datospersonalesNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            datospersonalesNuevo= this.datosPersonalesServices.creardatopersonal(datosPersonalesDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + datospersonalesNuevo.getId_datopersonale());
        response.put("DatoPersonal", datospersonalesNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminardatopersonal(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Datospersonales datospersonales= datosPersonalesServices.findByIddatopersponal(id);
            if (datospersonales == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datosPersonalesServices.eliminardatopersponal(id);
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
    public ResponseEntity<?> editardatopersonal(@PathVariable Long id, @RequestBody DatosPersonalesDto datosPersonalesDto) {
        Datospersonales datospersonalesEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            datospersonalesEditar= this.datosPersonalesServices.editardatopersonal(id, datosPersonalesDto);
            if (datospersonalesEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Dato Personal ", datospersonalesEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
