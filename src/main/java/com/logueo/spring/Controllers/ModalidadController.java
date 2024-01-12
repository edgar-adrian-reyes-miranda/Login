package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Modalidad;
import com.logueo.spring.Services.ModalidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
