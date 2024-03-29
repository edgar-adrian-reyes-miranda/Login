package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosIngresosDto;
import com.logueo.spring.Entity.DatosIngresos;
import com.logueo.spring.Repository.DatosIngresosRepository;
import com.logueo.spring.Services.DatosIngresosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ingresos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosIngresosController {
    @Autowired
    private DatosIngresosServices datosIngresosServices;
    @Autowired
    private DatosIngresosRepository datosIngresosRepository;

  //mapeo para obtenes la lista
    @GetMapping(path = {"/lista"})
    @ResponseStatus(HttpStatus.OK)
    public List<DatosIngresos> obtenertodos(){
        return datosIngresosServices.findAllingreso();
    }

    //paginacion
    @GetMapping(path = {"/paginacion"})
    public Page<DatosIngresos> getPaginacionDatos(@PageableDefault(page = 0, size = 12) Pageable pageable){
        return datosIngresosRepository.findAll(pageable);
    }

  //consulta por id
    @GetMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ConsultaporIdIngreso(@PathVariable Long id){
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
            response = "El datoIngreso con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosIngresos>(ingreso, HttpStatus.OK);
    }

  //guardar
    @PostMapping(path = {"/guardar"})
    public ResponseEntity<?> crearbeca(@RequestBody DatosIngresosDto datosIngresosDto) {
        DatosIngresos  ingresoNuevo = null;
        Map<String, Object> response = new HashMap<>();
        try {
            ingresoNuevo= this.datosIngresosServices.crearDatosIngresos(datosIngresosDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Dato Ingreso creado con éxito, con el ID: " + ingresoNuevo.getId_ingreso());
        response.put("Dato Ingreso", ingresoNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

  //Eliminar
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            DatosIngresos ingresodelete= this.datosIngresosServices.findByIdDatosIngresos(id);
            if (ingresodelete == null) {
                response.put("mensaje", "Error al eliminar. El Ingreso no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datosIngresosServices.eliminarDatosIngresos(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El dato Ingreso fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

  //Editar
    @PutMapping(path = {"/editar/{id}"})
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody DatosIngresosDto datosIngresosDto) {
        DatosIngresos ingresoEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            ingresoEditar= this.datosIngresosServices.editarDatosIngresos(id, datosIngresosDto);
            if (ingresoEditar == null) {
                response.put("mensaje", "Error al editar. El datoIngreso no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Dato Ingreso actualizado con éxito, con el ID: " + id);
        response.put("Datos Ingresos", ingresoEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
