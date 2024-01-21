package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DatosFTDDto;
import com.logueo.spring.Entity.DatosFTD;
import com.logueo.spring.Repository.DatosFTDRepository;
import com.logueo.spring.Services.DatoFTDServices;
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
@RequestMapping("/api/ftd")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosftdController {
    @Autowired
    private DatoFTDServices datoFTDServices;
    @Autowired
    private DatosFTDRepository datosFTDRepository;

    //mapeo para obtenes la lista de alumnos
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<DatosFTD> obtenertodos(){
        return datoFTDServices.findAllFTD();
    }

    //paginacion
    @GetMapping(path = {"/paginacion"})
    public Page<DatosFTD> getPaginacionDatos(@PageableDefault(page = 0, size = 12) Pageable pageable){
        return datosFTDRepository.findAll(pageable);
    }

    //mapeo para obtener alumnos por ID
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        DatosFTD ftd= null;
        String response = "";
        try {
            ftd= datoFTDServices.findByIdDatosFTD(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (ftd == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DatosFTD>(ftd, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody DatosFTDDto becaDto) {
        DatosFTD  ftdNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            ftdNuevo= this.datoFTDServices.crearDatosFTD(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + ftdNuevo.getId_ftd());
        response.put("beca", ftdNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            DatosFTD ftddelete= this.datoFTDServices.findByIdDatosFTD(id);
            if (ftddelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            datoFTDServices.eliminarDatosFTD(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El alumno fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //mapeo para editar un alumno
    @PutMapping(path="/editar/{id}")
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody DatosFTDDto becaDto) {
        DatosFTD ftdEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            ftdEditar= this.datoFTDServices.editarDatosFTD(id, becaDto);
            if (ftdEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Datos FTD", ftdEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
