package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="proyecto")
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto;
    private String nombre;
    private String avance;
    private String evaluacion;

    @ManyToMany(mappedBy = "proyectos", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("proyectos")
    private List<DatosFTD> datosFTDS;
}