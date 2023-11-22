package com.logueo.spring.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logueo.spring.Entity.Usuario;

@Repository
public interface UsuarioRepostory extends  JpaRepository <Usuario, Integer>{
	public Usuario findByUsername(String username);
	public Optional<Usuario> findById(Integer id);
}
