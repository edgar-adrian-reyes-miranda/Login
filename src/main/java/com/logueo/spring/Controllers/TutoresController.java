package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.Tutores;
import com.logueo.spring.Services.TutoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TutoresController {
    @Autowired
    private TutoresServices tutoresServices;
    
  //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<Tutores> obtenertodos(){
        return tutoresServices.findAllTurtor();
    }
}
