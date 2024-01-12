package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.EstatusInfotecDto;
import com.logueo.spring.Entity.EstatusInfotec;
import com.logueo.spring.Services.EstatusInfotecServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/estatus")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EstatusInfotecController {
    @Autowired
    private EstatusInfotecServices estatusInfotecServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<EstatusInfotec> obtenertodos(){
        return estatusInfotecServices.findAllEstatusInfotec();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarbecaPorID(@PathVariable Long id){
        EstatusInfotec estatus= null;
        String response = "";
        try {
            estatus= estatusInfotecServices.findByIdEstatusInfotec(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (estatus == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EstatusInfotec>(estatus, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody EstatusInfotecDto becaDto) {
        EstatusInfotec  Nuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Nuevo= this.estatusInfotecServices.crearEstatusInfotec(becaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + Nuevo.getId_estatus());
        response.put("Estatus Infotec", Nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            EstatusInfotec delete= this.estatusInfotecServices.findByIdEstatusInfotec(id);
            if (delete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            estatusInfotecServices.eliminarEstatusInfotec(id);
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
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody EstatusInfotecDto becaDto) {
        EstatusInfotec Editar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Editar= this.estatusInfotecServices.editarEstatusInfotec(id, becaDto);
            if (Editar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("Estatus Infotec", Editar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
