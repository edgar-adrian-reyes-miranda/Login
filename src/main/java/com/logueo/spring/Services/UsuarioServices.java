package com.logueo.spring.Services;

import com.logueo.spring.DTO.UsuarioDto;
import com.logueo.spring.Entity.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import com.logueo.spring.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UsuarioServices {
   @Autowired
   private UsuarioRepository usuarioRepository;
   
   @Autowired
   private AuthService authService;

   //lista general
    @Transactional(readOnly = true)
    public List<Usuario> findAllUsuarios(){
       return usuarioRepository.findAll();
    }

    //por id
    @Transactional(readOnly = true)
    public Usuario findByIdUsuarios(Long id){
       return usuarioRepository.findById(id).orElse(null);
    }

    //username
    @Transactional(readOnly = true)
    public Usuario  findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    //guardar
    @Transactional
    public Usuario crearUsuario(UsuarioDto usuarioDto){
       Usuario usuarios = new Usuario();
       usuarios.setUsername(usuarioDto.getUsername());
       usuarios.setPassword(BCrypt.hashpw(usuarioDto.getPassword(), BCrypt.gensalt()));
       usuarios.setCorreo(usuarioDto.getCorreo());
       return usuarioRepository.save(usuarios);
    }

    //eliminar
    @Transactional
    public void EliminarUsuario(Long id){
       usuarioRepository.deleteById(id);
    }

    //editar
    @Transactional
    public Usuario editarUsuarios (Long id, UsuarioDto usuarioDto){
       Usuario usuarios = usuarioRepository.findById(id).orElse(null);
       if (usuarios != null){
           usuarios.setUsername(usuarioDto.getUsername());
           usuarios.setCorreo(usuarioDto.getCorreo());
           usuarios.setPassword(BCrypt.hashpw(usuarioDto.getPassword(), BCrypt.gensalt()));
           usuarios.setDatosPersonales(usuarioDto.getDatosPersonales());
           return usuarioRepository.save(usuarios);
       }else{
           return null;
       }
    }
    
    //verificacion
    @Transactional(readOnly = true)
    public boolean VerificarCredencial(String username, String passwordplana) {
    	Usuario usuario = usuarioRepository.findByUsername(username);
    	
    	return usuario != null && authService.verificarContraseña(passwordplana, usuario.getPassword()); 
    }
    
}
