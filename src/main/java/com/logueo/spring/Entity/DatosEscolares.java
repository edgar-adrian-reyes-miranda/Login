package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="escolares")
public class DatosEscolares {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_escolar;
    private String matricula;
    private String correo_inst;
    private String carrera;
    @ManyToOne
    @JoinColumn(name="person_id")
    private DatosPersonales datosPersonales;
}
