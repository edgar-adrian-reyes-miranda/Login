package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String correo;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("usuario")
	private List<DatosPersonales> datosPersonales;
}
