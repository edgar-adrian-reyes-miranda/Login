package com.logueo.spring.Controllers;

import java.util.List;

import com.logueo.spring.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.logueo.spring.Repository.DatosEscolaresRepository;
import com.logueo.spring.Services.DatosEscolaresServices;

@RestController
@RequestMapping("/api/escolares")
//@CrossOrigin(origins = {"http://localhost:4200"} )
public class DatosEscolaresController {
	@Autowired
	private DatosEscolaresRepository datosEscolaresRepository;

	@Autowired
	private DatosEscolaresServices datosEscolaresServices;
	
	@GetMapping(path="/carrera")
	public ResponseEntity<List<DatosEscolares>> obtenerporcarrera(@RequestParam Carreras carrera){
	List<DatosEscolares> escolare=datosEscolaresServices.findByCarrera(carrera);
	return new ResponseEntity<>(escolare, HttpStatus.OK );
	}
	
	@GetMapping(path="/universidades")
	public ResponseEntity<List<DatosEscolares>> obtenerporuniversidad(@RequestParam Universidades universidades){
	List<DatosEscolares> escolare=datosEscolaresServices.findByUniversidades(universidades);
	return new ResponseEntity<>(escolare, HttpStatus.OK );
	}
	@GetMapping(path="/periodo")
	public ResponseEntity<List<DatosEscolares>> obtenerporuniversidad(@RequestParam Periodo periodo){
		List<DatosEscolares> escolare=datosEscolaresServices.findByPeriodo(periodo);
		return new ResponseEntity<>(escolare, HttpStatus.OK );
	}
	@GetMapping(path="/modalidad")
	public ResponseEntity<List<DatosEscolares>> obtenerporuniversidad(@RequestParam ModalidadesEscolares modalidadesEscolares){
		List<DatosEscolares> escolare=datosEscolaresServices.findByModaliadesEscolares(modalidadesEscolares);
		return new ResponseEntity<>(escolare, HttpStatus.OK );
	}
	@GetMapping(path="/planes")
	public ResponseEntity<List<DatosEscolares>> obtenerporuniversidad(@RequestParam PlanEstudios planEstudios){
		List<DatosEscolares> escolare=datosEscolaresServices.findByPlanEstudios(planEstudios);
		return new ResponseEntity<>(escolare, HttpStatus.OK );
	}
	
	@GetMapping(path = "/listaEscolares")
	public List<DatosEscolares>getAllescolares(){
		return datosEscolaresRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<DatosEscolares> getDatpescolarId(@PathVariable Integer id){
		DatosEscolares datosEscolares = datosEscolaresServices.obtenerEscolaresporId(id);
		if(datosEscolares != null) {
			return ResponseEntity.ok(datosEscolares);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(path = "/guardarescolar")
	public ResponseEntity<DatosEscolares> guardaarEscolar(@RequestBody DatosEscolares datosEscolares){
		try {
			DatosEscolares nuevoescolar= datosEscolaresServices.guardar(datosEscolares);
			return new ResponseEntity<>(nuevoescolar, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> eliminarescolar(@PathVariable Integer id){
	 datosEscolaresServices.eliminardatopersonal(id);
	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
