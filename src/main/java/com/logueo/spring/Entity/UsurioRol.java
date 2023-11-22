package com.logueo.spring.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="usuarioroles")
public class UsurioRol {
	@Id
	@GeneratedValue()
	private Integer usuarioRol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@ManyToOne
	private Rol rol;

}
