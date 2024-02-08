package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosEscolaresDto;
import com.logueo.spring.Entity.DatosEscolares;
import com.logueo.spring.Repository.DatosEscolaresRepository;
import com.logueo.spring.Services.DatosEscolaresServices;
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
@RequestMapping("/api/escolares")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosEscolaresController {
    @Autowired
    private DatosEscolaresServices datosEscolaresServices;

    @Autowired
    private DatosEscolaresRepository datosEscolaresRepository;

    //mapeo para obtenes la lista 
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<DatosEscolares> obtenertodos(){
        return datosEscolaresServices.findAllEscolares();
    }

    //paginacion
    @GetMapping(path = {"/paginacion"})
    public Page<DatosEscolares> getPaginacionDatos(@PageableDefault(page = 0, size = 12) Pageable pageable){
        return datosEscolaresRepository.findAll(pageable);
    }

    //consulta por id
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ConsultaporIdEscolares(@PathVariable Long id){
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
            response = "El Dato Escolar con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosEscolares>(beca, HttpStatus.OK);
    }

    //guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> CrearDatoEscolar(@RequestBody DatosEscolaresDto datosEscolaresDto) {
        DatosEscolares  NuevoEscolar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            NuevoEscolar= this.datosEscolaresServices.crearDatosEscolares(datosEscolaresDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "El dato Escolar creado con éxito, con el ID: " + NuevoEscolar.getId_escolar());
        response.put("Datos Escolar", NuevoEscolar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //Eliminar 
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> EliminarDatoEscolar(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            DatosEscolares becadelete= this.datosEscolaresServices.findByIdDatosEscolares(id);
            if (becadelete == null) {
                response.put("mensaje", "Error al eliminar. El dato Escolar no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datosEscolaresServices.eliminarDatosEscolares(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al Eliminar el dato Escolar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El dato Escolar fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //Editar
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<?> EditarDatoEscolar(@PathVariable Long id, @RequestBody DatosEscolaresDto datosEscolaresDto) {
        DatosEscolares EditarEscolar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            EditarEscolar= this.datosEscolaresServices.editarDatosEscolares(id, datosEscolaresDto);
            if (EditarEscolar == null) {
                response.put("mensaje", "Error al editar. El dato Escolar no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El dato Escolar actualizado con éxito, con el ID: " + id);
        response.put("Dato Escolar", EditarEscolar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
