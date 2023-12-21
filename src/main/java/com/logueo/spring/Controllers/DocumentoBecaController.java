package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.DocumentoBecaDto;
import com.logueo.spring.Services.DocumentoBecaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/documentobeca")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class DocumentoBecaController {
    @Autowired
    private DocumentoBecaServices documentoBecaServices;
    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<DocumentoBeca> obdurateness(){
        return documentoBecaServices.findAlldocumentobeca();
    }

    //mapeo para obtener alumnos por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> consultarDocumentoporbecaID(@PathVariable Long id){
        DocumentoBeca documentoBeca = null;
        String response = "";
        try {
            documentoBeca= documentoBecaServices.findByIddocumentobeca(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (documentoBeca == null) {
            response = "El alumno con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DocumentoBeca>(documentoBeca, HttpStatus.OK);
    }

    //mapeo para crear alumno
    @PostMapping(path = "/guardar")
    public ResponseEntity<?> creardocumentobeca(@RequestBody DocumentoBecaDto documentoBecaDto) {
        DocumentoBeca documentoBecaNuevo = null;
        Map<String, Object> response = new HashMap<>();

        try {
            documentoBecaNuevo= this.documentoBecaServices.creardocumento(documentoBecaDto);
        } catch (Exception e) {
            response.put("mensaje", "Error al realizar el insert. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        response.put("mensaje", "Alumno creado con éxito, con el ID: " + documentoBecaNuevo.getId_documento());
        response.put("Documento", documentoBecaNuevo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //mapeo para eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminardocumentobeca(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
             DocumentoBeca documentoBecaDelete = this.documentoBecaServices.findByIddocumentobeca(id);
            if (documentoBecaDelete == null) {
                response.put("mensaje", "Error al eliminar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
           documentoBecaServices.eliminardocumento(id);
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
    public ResponseEntity<?> editardocumentobeca(@PathVariable Long id, @RequestBody DocumentoBecaDto documentoBecaDto) {
        DocumentoBeca documentoBecaEditar = null;
        Map<String, Object> response = new HashMap<>();

        try {
            documentoBecaEditar= this.documentoBecaServices.editardocumento(id, documentoBecaDto);
            if (documentoBecaEditar == null) {
                response.put("mensaje", "Error al editar. El alumno no existe en la base de datos");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("mensaje", "Error al actualizar en la base de datos. Detalles: ");
            response.put("error", e.getMessage().concat(e.getCause().getLocalizedMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Alumno actualizado con éxito, con el ID: " + id);
        response.put("documento beca", documentoBecaEditar);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
