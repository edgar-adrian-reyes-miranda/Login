package com.logueo.spring.Entity;

import jakarta.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="datosEscolares")
public class DatosEscolares {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_escolares;
	private String correo_inst;
	private int matricula;
	@Enumerated(EnumType.STRING)
	private Carreras carrera;
	@Enumerated(EnumType.STRING)
	private Universidades universidades;
	@Enumerated(EnumType.STRING)
	private Periodo periodo;
	@Enumerated(EnumType.STRING)
	private ModalidadesEscolares modalidadesEscolares;
	@Enumerated(EnumType.STRING)
	private PlanEstudios planEstudios;

}
