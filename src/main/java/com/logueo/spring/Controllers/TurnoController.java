package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Turno;
import com.logueo.spring.Services.TurnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turno")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TurnoController {
    @Autowired
    private TurnoServices turnoServices;

  //mapeo para obtenes la lista
    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Turno> obtenertodos(){
        return turnoServices.findAllTurno();
    }
}
