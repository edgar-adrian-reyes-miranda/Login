package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.PlanEducativo;
import com.logueo.spring.Services.PlanEducativoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PlanEducativoController {
    @Autowired
    private PlanEducativoServices planEducativoServices;

    
  //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<PlanEducativo> obtenertodos() {
        return planEducativoServices.findAllPlanes();
    }


}
