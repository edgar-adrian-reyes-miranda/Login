package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosPersonalesDto;
import com.logueo.spring.Entity.DatosPersonales;
import com.logueo.spring.Repository.DatosPersonalesRepository;
import com.logueo.spring.Services.DatospersonalesServices;
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
@RequestMapping("/api/personales")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatospersonalesController {
    @Autowired
    private DatospersonalesServices datospersonalesServices;

    @Autowired
    private DatosPersonalesRepository datosPersonalesRepository;


  //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<DatosPersonales> obtenertodos(){
        return datospersonalesServices.findAllPersonal();
    }

    //paginacion
    @GetMapping(path = {"/paginacion"})
    public Page<DatosPersonales> getPaginacionDatos(@PageableDefault(page = 0, size = 12) Pageable pageable){
        return datosPersonalesRepository.findAll(pageable);
    }

  //consulta por id
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ConsultarporIdPersonal(@PathVariable Long id){
        DatosPersonales personal= null;
        String response = "";
        try {
            personal= datospersonalesServices.findByIdDatosPersonales(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (personal == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosPersonales>(personal, HttpStatus.OK);
    }

  //guardar
    @PostMapping(path = {"/guardar"})
    public ResponseEntity<?> CrearDatosPersonales(@RequestBody DatosPersonalesDto datosPersonalesDto) {
        DatosPersonales  personalNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            personalNuevo= this.datospersonalesServices.crearDatosPersonales(datosPersonalesDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            if(e.getCause() != null){
                response.put("Error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            }else{
                response.put("Error", e.getMessage());
            }
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno creado con éxito, con el ID: " + personalNuevo.getId_person());
        response.put("Dato Personal", personalNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

  //Eliminar
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> EliminarPersonal(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            DatosPersonales personaldelete= this.datospersonalesServices.findByIdDatosPersonales(id);
            if (personaldelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datospersonalesServices.eliminarDatosPersonales(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El alumno fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

  //Editar
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<?> EditarPersonal(@PathVariable Long id, @RequestBody DatosPersonalesDto datosPersonalesDto) {
        DatosPersonales personalEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            personalEditar= this.datospersonalesServices.editarDatosPersonales(id, datosPersonalesDto);
            if (personalEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Datos Personales", personalEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
