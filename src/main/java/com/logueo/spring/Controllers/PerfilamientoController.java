package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.PerfilamientoDto;
import com.logueo.spring.Entity.Perfilamiento;
import com.logueo.spring.Services.PerfilamientoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/perfilamiento")
public class PerfilamientoController {
    @Autowired
    private PerfilamientoServices perfilamientoServices;

  //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Perfilamiento> obtenertodos(){
        return perfilamientoServices.findAllPerfilamiento();
    }

  //consulta por id
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ConsulatporIdPerfilamiento(@PathVariable Long id){
        Perfilamiento perfil= null;
        String response = "";
        try {
            perfil=perfilamientoServices.findByIdPerfilamiento(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (perfil == null) {
            response = "El Perfilamiento con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Perfilamiento>(perfil, HttpStatus.OK);
    }
    
  //guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody PerfilamientoDto perfilamientoDto) {
        Perfilamiento  Nuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Nuevo= this.perfilamientoServices.crearPerfilamiento(perfilamientoDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Perfilamiento creado con éxito, con el ID: " + Nuevo.getId_perfilamiento());
        response.put("Perfilamiento", Nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

  //Eliminar
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Perfilamiento delete= this.perfilamientoServices.findByIdPerfilamiento(id);
            if (delete == null) {
                response.put("mensaje", "Error al eliminar. El perfilamiento no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            perfilamientoServices.eliminarPerfilamiento(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El perfilamiento fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

  //Editar
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> EditarPerfilamiento(@PathVariable Long id, @RequestBody PerfilamientoDto perfilamientoDto) {
        Perfilamiento Editar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Editar= this.perfilamientoServices.editarPerfilamiento(id, perfilamientoDto);
            if (Editar == null) {
                response.put("mensaje", "Error al editar. El Perfilamiento no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Perfilamiento actualizado con éxito, con el ID: " + id);
        response.put("Perfilamiento",Editar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}