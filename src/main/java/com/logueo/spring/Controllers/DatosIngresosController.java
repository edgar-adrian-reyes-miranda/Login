package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosIngresosDto;
import com.logueo.spring.Entity.DatosIngresos;
import com.logueo.spring.Services.DatosIngresosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/api/ingresos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosIngresosController {
    @Autowired
    private DatosIngresosServices datosIngresosServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping(path = {"/lista"})
    @ResponseStatus(HttpStatus.OK)
    public List<DatosIngresos> obtenertodos(){
        return datosIngresosServices.findAllingreso();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        DatosIngresos ingreso= null;
        String response = "";
        try {
            ingreso= datosIngresosServices.findByIdDatosIngresos(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (ingreso == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosIngresos>(ingreso, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = {"/guardar"})
    public ResponseEntity<?> crearbeca(@RequestBody DatosIngresosDto becaDto) {
        DatosIngresos  ingresoNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            ingresoNuevo= this.datosIngresosServices.crearDatosIngresos(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + ingresoNuevo.getId_ingreso());
        response.put("beca", ingresoNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            DatosIngresos ingresodelete= this.datosIngresosServices.findByIdDatosIngresos(id);
            if (ingresodelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datosIngresosServices.eliminarDatosIngresos(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El alumno fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //mapeo para editar un alumno
    @PutMapping(path = {"/editar/{id}"})
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody DatosIngresosDto becaDto) {
        DatosIngresos ingresoEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            ingresoEditar= this.datosIngresosServices.editarDatosIngresos(id, becaDto);
            if (ingresoEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Datos Ingresos", ingresoEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
