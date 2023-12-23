package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Periodo;
import com.logueo.spring.Services.PeriodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/api/periodo")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PeriodoController {
    @Autowired
    private PeriodoServices periodoServices;
    //mapeo para obtenes la lista de alumnos
    @GetMapping(path={"/lista"})
    @ResponseStatus(HttpStatus.OK)
    public List<Periodo> obtenertodos(){
        return periodoServices.findAllPeriodo();
    }

}
