package com.logueo.spring.Controllers;


import com.logueo.spring.Entity.Tramite;
import com.logueo.spring.Services.TramiteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/tramite")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TramiteController {
    @Autowired
    private TramiteServices tramiteServices;

  //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Tramite> obtenertodos(){
        return tramiteServices.findAllTramite();
    }

  //consulta por id
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>ConsultaporIdTramite(@PathVariable Long id){
        Tramite tramite= null;
        String response = "";
        try {
            tramite= tramiteServices.findByIdTramite(id);
        } catch (Exception e) {
            response = "Error al realizar la consulta. Detalles: ";
            response = response.concat(e.getMessage().concat(e.getMessage().toString()));
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (tramite == null) {
            response = "El Tramite con el ID: ".concat(id.toString()).concat(" no existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Tramite>(tramite, HttpStatus.OK);
    }
}
