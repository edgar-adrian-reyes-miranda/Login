package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.PlanEducativo;
import com.logueo.spring.Services.PlanEducativoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.*;
@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PlanEducativoController {
    @Autowired
    private PlanEducativoServices planEducativoServices;
    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<PlanEducativo> obtenertodos(){
        return planEducativoServices.findAllPlanes();
    }
}
