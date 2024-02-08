package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.EnlaceDto;
import com.logueo.spring.Entity.Enlace;
import com.logueo.spring.Services.EnlaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enlace")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EnlaceController {
    @Autowired
    private EnlaceServices enlaceServices;

    //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Enlace> obtenertodos() {
        return enlaceServices.findAllEnlace();
    }

    //consulta por id
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ConsultaporIdEnlace(@PathVariable Long id) {
        Enlace enlace = null;
        String response = "";
        try {
            enlace = enlaceServices.findByIdEnlace(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (enlace == null) {
            response = "El Enlace con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Enlace>(enlace, HttpStatus.OK);
    }

    //guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> crearEnlace(@RequestBody EnlaceDto enlaceDto) {
        Enlace nuevoenlace = null;
        Map<String, Object> response = new HashMap<>();
        try {
            nuevoenlace = this.enlaceServices.crearEnlace(enlaceDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert.Detalles:");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("mensaje", "El enlace ha sido creado por exito, con el ID :" + nuevoenlace.getId_enlace());
        response.put("Enlace", nuevoenlace);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEnlace(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Enlace enlaceDelte = this.enlaceServices.findByIdEnlace(id);
            if (enlaceDelte == null) {
                response.put("mensaje", "Error al eliminar Al enlace no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            enlaceServices.eliminarEnlace(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El enlace fue eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //editar
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<?>editarEnlace(@PathVariable Long id,@RequestBody EnlaceDto enlaceDto){
        Enlace editar= null;
        Map<String,Object>response = new HashMap<>();
        try {
            editar= this.enlaceServices.editarEnlace(id, enlaceDto);
            if (editar == null){
                response.put("mensaje","Error al editar, EL enlace no existe en la base de datos");
                return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            response.put("mensaje","Error al actualizar en la base de datos. Detalles");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","Enlace actualizado con exito con el ID"+id);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
