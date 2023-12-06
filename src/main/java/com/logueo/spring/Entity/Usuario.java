package com.logueo.spring.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String nombre;
	private String p_apellido;
	private String s_apellido;
	private String correo;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
	@JsonIgnore
	private Set<UsurioRol> usuarioRoles = new HashSet<>() ;
	 
}
