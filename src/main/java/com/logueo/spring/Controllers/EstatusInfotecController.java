package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.EstatusInfotec;
import com.logueo.spring.Services.EstatusInfotecServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estatus")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EstatusInfotecController {
    @Autowired
    private EstatusInfotecServices estatusInfotecServices;

  //mapeo para obtenes la lista
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<EstatusInfotec> obtenertodos(){
        return estatusInfotecServices.findAllEstatusInfotec();
    }

  //consulta por id
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
}
