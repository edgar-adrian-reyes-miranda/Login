package com.logueo.spring.Controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.logueo.spring.DTO.AdministradorDto;
import com.logueo.spring.Entity.Administrador;
import com.logueo.spring.Services.AdministradorServices;

@RestController
@RequestMapping("/api/adminis")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AdministradorControllers {

    @Autowired
    private AdministradorServices administradorServices;
    
    //mapeo para obtenes la lista
    @GetMapping(path = "/lista")
    public ResponseEntity<List<Administrador>> getAllAdministradores(){
        List<Administrador> administradores = administradorServices.findAllAdmins();
        return new ResponseEntity<>(administradores, HttpStatus.OK);
    }
    
  //consulta por id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Administrador> getAdminById(@PathVariable Long id){
    	Administrador ids = administradorServices.findByIdAdminstrador(id);
        return ids != null?
        		new ResponseEntity<>(ids, HttpStatus.OK):
        			new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
  //guardar
    @PostMapping("/registro")
    public ResponseEntity<Administrador> registroAdmin(@RequestBody AdministradorDto administradorDto){
    	Administrador nuevo = administradorServices.crearAdmins(administradorDto);
        return  new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    
    //identificar
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody AdministradorDto administradorDto){
        try {
             boolean authenticado = realiazarauthentication(administradorDto.getUsername(), administradorDto.getPassword());

            if (authenticado) {
                return ResponseEntity.ok("");
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales Incorrectas");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }
    
  //Eliminar
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> EliminarAdministrador(@PathVariable Long id){
        administradorServices.EliminarAdmins(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

  //Editar
    @PutMapping(path ="/editar/{id}")
    public ResponseEntity<Administrador> editarAdmin(@PathVariable Long id, @RequestBody AdministradorDto administradorDto){
    	Administrador editar= administradorServices.editarAdministradores(id, administradorDto);
     return  editar != null?
     	new ResponseEntity<>(editar, HttpStatus.OK):
     	new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private boolean realiazarauthentication(String username, String password){
        Administrador admins = administradorServices.findByUsername(username);
        return admins != null && admins.getPassword().equals(password);
    }
}
