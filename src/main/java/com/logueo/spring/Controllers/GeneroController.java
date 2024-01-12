package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Genero;
import com.logueo.spring.Services.GeneroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
@CrossOrigin(origins = {"http://localhost:4200"})
public class GeneroController {
    @Autowired
    private GeneroServices generoServices;
    ///obtener todos
    @GetMapping({"/lista"})
    @ResponseStatus(HttpStatus.OK)
    public List<Genero>obtenertodos(){
        return  generoServices.findAllGenero();
    }
    //obtener por id
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?>ConsultarporId(@PathVariable Long id){
        Genero genero= null;
        String response="";
        try {
            genero= generoServices.findByGenero(id);
        }catch (Exception e){
            response="Error al realizar la consulta. Detalles:";
            response= response.concat(e.getMessage().concat(e.getMessage().toString()));
            return  new ResponseEntity<String >(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (genero == null){
            response = "El genero con el ID: ".concat(id.toString()).concat("No existe en la base de datos");
            return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Genero>(genero, HttpStatus.OK);
    }

}
