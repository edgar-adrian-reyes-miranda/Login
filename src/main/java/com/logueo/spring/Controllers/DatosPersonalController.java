package com.logueo.spring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logueo.spring.Entity.Datospersonales;
import com.logueo.spring.Repository.DatosPersonalesRepository;
import com.logueo.spring.Services.DatosPersonalesServices;

@RequestMapping("/api/datospersonales")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class DatosPersonalController {
	@Autowired
	private DatosPersonalesServices datosPersonalesServices;
	
	@Autowired
	private DatosPersonalesRepository datosPersonalesRepository;
	
	@GetMapping(path = "/listadatosper")
	public List<Datospersonales> getAlldatopersonal(){
		return datosPersonalesRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Datospersonales>getDatopersonalById(@PathVariable Integer id){
		Datospersonales datospersonales= datosPersonalesServices.obtenerUsuarioporId(id);
		if(datospersonales != null) {
			return ResponseEntity.ok(datospersonales);
		}else {
		return ResponseEntity.notFound().build();
	}
	}
	
	@PostMapping(path = "/guardardato")
	public ResponseEntity<Datospersonales> guardardato(@RequestBody Datospersonales datospersonales)throws Exception{
		try {
            Datospersonales nuevoDatosPersonales = datosPersonalesServices.guardar(datospersonales);
            return new ResponseEntity<>(nuevoDatosPersonales, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@DeleteMapping(path="/{id}")
    public ResponseEntity<Void> eliminarDatosPersonales(@PathVariable Integer id) {
        datosPersonalesServices.eliminardatopersonal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
