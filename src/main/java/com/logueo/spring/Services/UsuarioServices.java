package com.logueo.spring.Services;

import org.springframework.stereotype.Service;
import java.util.*;
import com.logueo.spring.Entity.*;


@Service
public interface UsuarioServices {
	public boolean authenticador(String username, String password);
	public Usuario guardarUsuario(Usuario usuario, Set<UsurioRol> roles)throws Exception;
	public Usuario obtenerUsuario(String username);
	public void eliminarUsuario(Integer usuarioid);
	public  Usuario obtenerUsuarioPorId(Long id);
}
