package com.logueo.spring.Controllers;

import com.logueo.spring.Entity.PlanEducativo;
import com.logueo.spring.Repository.PlanEstudiosRepository;
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

    @Autowired
    private PlanEstudiosRepository planEstudiosRepository;

    //mapeo para obtenes la lista de alumnos
    @GetMapping(path = "/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<PlanEducativo> obtenertodos() {
        return planEducativoServices.findAllPlanes();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePlanEducativo(@PathVariable Long id) {

        PlanEducativo plan = planEstudiosRepository.findById(id).orElse(null);

        if (plan != null) {

            plan.setDeleted(true);
            planEstudiosRepository.save(plan);

            return ResponseEntity.ok().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> restorePlan(@PathVariable Long id) {
        System.out.println("Restauracion plan con id:"+ id);
        PlanEducativo plan = planEstudiosRepository.findById(id).orElse(null);


        if (plan != null) {
            System.out.println("plan encontrado:"+ plan.getNombre());
            plan.restore();
            planEstudiosRepository.save(plan);
            System.out.println("Restauracion exitosa: "+ plan.getNombre());
            return ResponseEntity.ok().build();
        } else {
            System.out.println("Plan no encontrado");
            return ResponseEntity.notFound().build();
        }
    }
}
