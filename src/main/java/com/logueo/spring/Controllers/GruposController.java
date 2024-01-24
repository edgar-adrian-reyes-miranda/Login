package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.GruposDto;
import com.logueo.spring.Entity.Grupos;
import com.logueo.spring.Services.GrupoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class GruposController {
    @Autowired
    private GrupoServices grupoServices;

  //mapeo para obtenes la list
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Grupos> obtenertodos(){
        return grupoServices.findAllGrupo();
    }

  //consulta por id
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ConsultaporIDGrupo(@PathVariable Long id){
        Grupos grupo= null;
        String response = "";
        try {
            grupo= grupoServices.findByIdGrupos(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (grupo == null) {
            response = "El Grupo con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Grupos>(grupo, HttpStatus.OK);
    }

  //guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearbeca(@RequestBody GruposDto gruposDto) {
        Grupos  Nuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
           Nuevo= this.grupoServices.crearGrupos(gruposDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Grupo creado con éxito, con el ID: " + Nuevo.getId_grupo());
        response.put("Grupo", Nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

  //Eliminar
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarbeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Grupos delete= this.grupoServices.findByIdGrupos(id);
            if (delete == null) {
                response.put("mensaje", "Error al eliminar. El Grupo no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            grupoServices.eliminarGrupos(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Grupo fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

  //Editar
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody GruposDto gruposDto) {
        Grupos Editar = null;
        Map<String, Object> response = new HashMap<>();
        try {
            Editar= this.grupoServices.editarGrupos(id, gruposDto);
            if (Editar == null) {
                response.put("mensaje", "Error al editar. El Grupo no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Grupo actualizado con éxito, con el ID: " + id);
        response.put("Grupos", Editar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}