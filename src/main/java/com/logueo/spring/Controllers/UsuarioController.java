package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.UsuarioDto;
import com.logueo.spring.Entity.Usuario;
import com.logueo.spring.Services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UsuarioController {
    @Autowired
    private UsuarioServices usuarioServices;
    
  //mapeo para obtenes la lista
    @GetMapping("/lista")
    public List<Usuario> getAllUsuarios() {
        return usuarioServices.findAllUsuarios();
    }
    
  //consulta por id
    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioServices.findByIdUsuarios(id);
    }
    
  //guardar
    @PostMapping(path = "/registro")
    public Usuario registroUsuario(@RequestBody UsuarioDto usuarioDto) {
        return usuarioServices.crearUsuario(usuarioDto);
    }

  //guardar
    @PostMapping(path = "/login")
    public ResponseEntity<String> login(@RequestBody UsuarioDto usuarioDto) {
        try {
            boolean autenticado =  usuarioServices.VerificarCredencial(usuarioDto.getUsername(), usuarioDto.getPassword());

            if (autenticado) {
                return ResponseEntity.status(HttpStatus.OK).body("exito");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales Incorrectas");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }

  //Eliminar
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioServices.EliminarUsuario(id);
    }
    
  //Editar
    @PutMapping("/editar/{id}")
    public Usuario editarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return usuarioServices.editarUsuarios(id, usuarioDto);
    }

   
}

