package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Genero;
import com.logueo.spring.Services.GeneroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
@CrossOrigin(origins = {"http://localhost:4200"})
public class GeneroController {
    @Autowired
    private GeneroServices generoServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Genero> obtenertodos(){
        return generoServices.findAllgenero();
    }
}
