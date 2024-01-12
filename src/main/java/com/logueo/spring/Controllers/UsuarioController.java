package com.logueo.spring.Controllers;

import com.logueo.spring.DTO.AdministradorDto;
import com.logueo.spring.DTO.UsuarioDto;
import com.logueo.spring.Entity.Administrador;
import com.logueo.spring.Entity.Usuario;
import com.logueo.spring.Repository.AdminsitradorRepository;
import com.logueo.spring.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping(path = {"/registro"})
	public String registroUsuario(@RequestBody UsuarioDto usuariodto) {
		if (usuarioRepository.findByUsername(usuariodto.getUsername()) != null) {
			return "El nombre de usuario ya está en uso. Por favor, elige otro.";
		}

		Usuario usuario = new Usuario();
		usuario.setUsername(usuariodto.getUsername());
		usuario.setPassword(usuariodto.getPassword());
		usuario.setCorreo(usuariodto.getCorreo());

		System.out.println("Credenciales durante el registro: " + usuariodto.getUsername() + ", " + usuariodto.getPassword());

		usuarioRepository.save(usuario);
		return "Registro exitoso";
	}


	@PostMapping(path="/login")
	public String login(@RequestBody UsuarioDto loginDTO) {
		Usuario usuario = usuarioRepository.findByUsername(loginDTO.getUsername());

		System.out.println("Credenciales durante el login: " + loginDTO.getUsername() + ", " + loginDTO.getPassword());

		if (usuario != null && loginDTO.getPassword().equals(usuario.getPassword())) {
			return "Inicio de sesión exitoso";
		} else {
			return "Credenciales incorrectas. Por favor, inténtalo de nuevo.";
		}
	}

	@Autowired
	private AdminsitradorRepository adminsitradorRepository;
	@PostMapping(path = {"/registroadmin"})
	public String registroAdmin(@RequestBody AdministradorDto usuariodto) {
		if (adminsitradorRepository.findByCorreo(usuariodto.getCorreo()) != null) {
			return "El correo  ya está en uso. Por favor, elige otro.";
		}

		Administrador admin = new Administrador();
		admin.setPassword(usuariodto.getPassword());
		admin.setCorreo(usuariodto.getCorreo());

		System.out.println("Credenciales durante el registro: " + usuariodto.getCorreo() + ", " + usuariodto.getPassword());

		adminsitradorRepository.save(admin);
		return "Registro exitoso administrador";
	}


	@PostMapping(path="/loginadmin")
	public String loginadmin(@RequestBody AdministradorDto loginDTO) {
		Administrador admin = adminsitradorRepository.findByCorreo(loginDTO.getCorreo());

		System.out.println("Credenciales durante el login de administrador: " + loginDTO.getCorreo() + ", " + loginDTO.getPassword());

		if (admin != null && loginDTO.getPassword().equals(admin.getPassword())) {
			return "Inicio de sesión exitoso administrador";
		} else {
			return "Credenciales incorrectas. Por favor, inténtalo de nuevo administrador.";
		}
	}


}

