package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="escolares")
public class DatosEscolares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_escolar;
    private int matricula;
    private String correo_inst;
    @ManyToOne
    @JoinColumn(name="carrera_id")
    private Carreras carrerasList;
}
