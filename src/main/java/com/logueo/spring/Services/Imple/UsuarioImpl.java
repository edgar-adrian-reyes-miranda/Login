package com.logueo.spring.Services.Imple;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.*;
import com.logueo.spring.Entity.*;
import com.logueo.spring.Repository.RolRepository;
import com.logueo.spring.Repository.UsuarioRepostory;
import com.logueo.spring.Services.UsuarioServices;

@Data
@Service
public class UsuarioImpl  implements UsuarioServices{
	@Autowired
	private UsuarioRepostory usuarioRepostory;
	@Autowired
	private RolRepository reposittory;
	
	public boolean authenticador(String username, String password) {
		System.out.print("Usuario recibido: "+ username);
		System.out.print("Contraseña recibida: "+password);
		
		Usuario usuario= usuarioRepostory.findByUsername(username);
		///VERIFICA QUE SI EXISTA SI NO DE LO CONTRARIO Y CONCIDA
		if(usuario!= null && usuario.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario, Set<UsurioRol> roles) throws Exception {
		Usuario usuarioLocal= usuarioRepostory.findByUsername(usuario.getUsername());
		if(usuarioLocal !=null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya está presente");
		}
		else {
			for(UsurioRol usuarioRol:roles) {
				reposittory.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(roles);
			usuarioLocal = usuarioRepostory.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		// TODO Auto-generated method stub
		return usuarioRepostory.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Integer usuarioid) {
		usuarioRepostory.deleteById(usuarioid);
		
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		Optional<Usuario> usuOptional= usuarioRepostory.findById(null);
		return usuOptional.orElse(null);
	}

	


	
	
	

}
