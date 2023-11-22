package com.logueo.spring.Controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.logueo.spring.Entity.Usuario;
import com.logueo.spring.Entity.UsurioRol;
import com.logueo.spring.Repository.UsuarioRepostory;
import com.logueo.spring.Services.UsuarioServices;

@RequestMapping("/api/login")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class UsuarioController {
	
	@Autowired
	private UsuarioServices usuarioServices;
	
	@Autowired
	private UsuarioRepostory usuarioRepostory;
	////busqueda en pegeneral
	@GetMapping(path="/buscar")
	public List<Usuario> getAllUsuario(){
		return usuarioRepostory.findAll();
	}
	/////buscar por id
	@GetMapping(path ="/{id}")
	public ResponseEntity<Usuario>getUsuarioById(@PathVariable Long id) {
		Usuario usuario= usuarioServices.obtenerUsuarioPorId(id);
		if(usuario !=null) {
			return ResponseEntity.ok(usuario);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	/////acceder al login
	@PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        try {
            // Realizar la autenticación utilizando el servicio
            boolean authenticated = usuarioServices.authenticador(usuario.getUsername(), usuario.getPassword());

            if (authenticated) {
                // Devolver un token u otra información de éxito según sea necesario
                return ResponseEntity.ok("Inicio de sesión exitoso");
            } else {
                // Devolver una respuesta de error si la autenticación falla
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nombre de usuario o contraseña incorrectos");
            }
        } catch (Exception e) {
            // Manejar otras excepciones
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }
	
	//metodo para guardar y actualizar
	@PostMapping(path = "/guardar")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception {
	    Set<UsurioRol> usuarioRoles = new HashSet<>();

	    if (usuario.getUsuarioRoles() != null) {
	        for (UsurioRol usuarioRol : usuario.getUsuarioRoles()) {
	         
	            usuarioRoles.add(usuarioRol);
	        }
	    }

	    return usuarioServices.guardarUsuario(usuario, usuarioRoles);
	}

		
		@GetMapping(path = "/{username}")
		public Usuario obtenerUsuario(@PathVariable("username") String username) {
			return usuarioServices.obtenerUsuario(username);
		}
		
		@DeleteMapping("/{usuarioId}")
		public void eliminarUsuario(@PathVariable("usuarioId") Integer usuarioId) {
			usuarioServices.eliminarUsuario(usuarioId);
		}
	

}
