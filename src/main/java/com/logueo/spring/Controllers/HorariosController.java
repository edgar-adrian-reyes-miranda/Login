package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Horarios;
import com.logueo.spring.Services.HorarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
@RestController
@RequestMapping("/api/horario")
@CrossOrigin(origins = {"http://localhost:4200"})
public class HorariosController {
    @Autowired
    private HorarioServices horarioServices;

    //mapeo para obtenes la lista de alumnos
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Horarios> obtenertodos(){
        return horarioServices.findAllHorario();

    }

}
