package com.logueo.spring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logueo.spring.Entity.Rol;
import com.logueo.spring.Repository.RolRepository;

@RestController
@RequestMapping("/api/rol")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RolServices {
	
	@Autowired
	RolRepository repository;
	
	@GetMapping(path = "/buscar")
	public List<Rol> getAllRol(){
		return repository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Rol sRol(@RequestBody Rol rol) {
		return repository.save(rol);
	}

}
