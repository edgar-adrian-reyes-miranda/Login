package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Horarios;
import com.logueo.spring.Services.HorarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
