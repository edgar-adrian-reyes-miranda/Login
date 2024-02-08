package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.UniversidadesDto;
import com.logueo.spring.Entity.Universidades;
import com.logueo.spring.Repository.UniversidadRepository;
import com.logueo.spring.Services.UniversidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/universidades")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UniversidadesController {
    @Autowired
    private UniversidadServices universidadServices;
    @Autowired
    private UniversidadRepository universidadRepository;

  //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Universidades> obtenertodos(){
        return universidadServices.findAlluniversidad();
    }

  //paginacion
    @GetMapping(path = {"/page"})
    public Page<Universidades> getPaginacion(@PageableDefault (page = 0, size = 8)Pageable pageable){
        return universidadRepository.findAll(pageable);
    }

  //consulta por id
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>ConsultaIdUniversidad(@PathVariable Long id){
        Universidades uni= null;
        String response = "";
        try {
            uni= universidadServices.findByIdUniversidades(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (uni == null) {
            response = "La universidad con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Universidades>(uni, HttpStatus.OK);
    }

  //guardar
    @PostMapping(path = "/guardar")
    public ResponseEntity<?>CrearUniversidad(@RequestBody UniversidadesDto universidadesDto) {
        Universidades  Nuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Nuevo= this.universidadServices.crearUniversidades(universidadesDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Universidad creado con éxito, con el ID: " + Nuevo.getId_uni());
        response.put("Universidades", Nuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

  //Eliminar
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarUniversidad(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            Universidades delete= this.universidadServices.findByIdUniversidades(id);
            if (delete == null) {
                response.put("mensaje", "Error al eliminar. La universidad no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            universidadServices.eliminarUniversidades(id);
        } catch (Exception e) {
            response.put("mensaje", "Error al eliminar en base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La universidad fue eliminado con éxito.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //soft deleted
    @DeleteMapping(path="/soft/{id}")
    public void deleteById(@PathVariable Long id){
        universidadRepository.deleteById(id);
    }

  //Editar
    @PutMapping(path = "/editar/{id}")
    public ResponseEntity<?> editarbeca(@PathVariable Long id, @RequestBody UniversidadesDto universidadesDto) {
        Universidades Editar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            Editar= this.universidadServices.editarUniversidades(id, universidadesDto);
            if (Editar == null) {
                response.put("mensaje", "Error al editar.La Universidad no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Universidad actualizado con éxito, con el ID: " + id);
        response.put("Universidades", Editar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
