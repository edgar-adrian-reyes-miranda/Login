package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="datospersonales")
public class Datospersonales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_datopersonale;
	private String nombre;
	private String P_apellido;
	private String S_apellido;
	private int telefono;
	private int telefonocasa;
	private String Genero;
	private String curp;
	@ManyToMany
	@JoinTable(name="datospersonales_datosftd",
					joinColumns = @JoinColumn(name="datopersonale_id"),
					inverseJoinColumns = @JoinColumn(name="ftd_id"))
	private List<DatosFTD> datosFTDs;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Usuario> usuario;
	
}
