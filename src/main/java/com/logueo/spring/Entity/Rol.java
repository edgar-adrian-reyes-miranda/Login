package com.logueo.spring.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Data
@Entity
@Table(name="roles")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre_rol;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
	private Set<UsurioRol> usuarioRoles= new HashSet<>();

}
