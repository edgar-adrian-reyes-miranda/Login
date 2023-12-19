package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosFTDDto;
import com.logueo.spring.Entity.DatosFTD;
import com.logueo.spring.Services.DatosFtdServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/datosftd")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosFtdController {
    @Autowired
    private DatosFtdServices datosFtdServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<DatosFTD> obtenertodos(){
        return datosFtdServices.findAlldatosftd();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultardatosftdPorID(@PathVariable Long id){
        DatosFTD datosFTD = null;
        String response = "";
        try {
            datosFTD= datosFtdServices.findByIddatoftd(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (datosFTD == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosFTD>(datosFTD, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> creardatosftd(@RequestBody DatosFTDDto datosFTDDto) {
        DatosFTD datosftdNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            datosftdNuevo = this.datosFtdServices.creardatosftd(datosFTDDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + datosftdNuevo.getId_ftd());
        response.put("DatosFtd", datosftdNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminardatosftd(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
             DatosFTD datosFTDeliminar= this.datosFtdServices.findByIddatoftd(id);
            if (datosFTDeliminar == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datosFtdServices.eliminardatosftd(id);
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
    public ResponseEntity<?> editardatosftd(@PathVariable Long id, @RequestBody DatosFTDDto datosFTDDto) {
        DatosFTD datosFTDEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            datosFTDEditar = this.datosFtdServices.editardatoftd(id, datosFTDDto);
            if (datosFTDEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("DatosFTD", datosFTDEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
