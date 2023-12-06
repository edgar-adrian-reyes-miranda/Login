package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="datospersonales")
public class Datospersonales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_datopersonale;
	private String nombre;
	private String p_apellido;
	private String s_apellido;
	private String correo;
	private String telefonocasa;
	private String Genero;
	private String curp;
	
}
