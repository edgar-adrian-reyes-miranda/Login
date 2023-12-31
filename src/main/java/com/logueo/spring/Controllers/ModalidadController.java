package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Modalidad;
import com.logueo.spring.Services.ModalidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;

@RestController
@RequestMapping("/api/modalidad")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ModalidadController {
    @Autowired
    private ModalidadServices modalidadServices;
    //mapeo para obtenes la lista de alumnos
    @GetMapping(path = {"/lista"})
    @ResponseStatus(HttpStatus.OK)
    public List<Modalidad> obtenertodos(){
        return modalidadServices.findAllModalidad();
    }
}
