package com.logueo.spring.Controllers;

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

    @GetMapping({"/lista"})
    public List<Administrador> getAllAdministradores(){
        return administradorServices.findAllAdmins();
    }
    @GetMapping({"/{id}"})
    public Administrador getAdminById(@PathVariable Long id){
        return  administradorServices.findByIdAdminstrador(id);
    }

    @PostMapping({"/registro"})
    public Administrador registroAdmin(@RequestBody AdministradorDto administradorDto){
        return administradorServices.crearAdmins(administradorDto);
    }
    @PostMapping({"/login"})
    public ResponseEntity<String> login(@RequestBody AdministradorDto administradorDto){
        try {
             boolean authenticado = realiazarauthentication(administradorDto.getCorreo(), administradorDto.getPassword());

            if (authenticado) {
                return ResponseEntity.status(HttpStatus.OK).body("exito");
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales Incorrectas");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }

    @DeleteMapping({"/{id}"})
    public void EliminarAdministrador(@PathVariable Long id){
        administradorServices.EliminarAdmins(id);
    }

    @PutMapping({"/editar/{id}"})
    public Administrador editarAdmin(@PathVariable Long id, @RequestBody AdministradorDto administradorDto){
        return administradorServices.editarAdministradores(id, administradorDto);
    }

    private boolean realiazarauthentication(String correo, String password){
        Administrador admins = administradorServices.findByCorreo(correo);
        return admins != null && admins.getPassword().equals(password);
    }
}
