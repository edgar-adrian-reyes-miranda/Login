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
	private Integer id_datopersonale;
	private String telefonocasa;
	private String Genero;
	private String curp;
	@ManyToMany
	@JoinTable(name="datospersonales_datosftd",
					joinColumns = @JoinColumn(name="datopersonale_id"),
					inverseJoinColumns = @JoinColumn(name="ftd_id"))
	private List<DatosFTD> datosFTDs;
	@ManyToMany
	@JoinTable(name="datospersonales_datosescolares",
					joinColumns = @JoinColumn(name="datopersonale_id"),
					inverseJoinColumns = @JoinColumn(name="escolares_id"))
	private List<DatosEscolares> datosEscolares;
	@ManyToMany
	@JoinTable(name="datospersonales_datosingreso",
					joinColumns = @JoinColumn(name="datopersonale_id"),
					inverseJoinColumns = @JoinColumn(name="ingreso_id"))
	private List<DatosIngresos> datosIngresos ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Usuario> usuario;
	
}
