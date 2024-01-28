package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ftd")
public class DatosFTD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ftd;
    private String area;
    private String beca;
    private String becadocumenot;
    private String fecha_ingreso;
    private String fecha_termino;
    private String matricula_ftd;
    private String correo_becario;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="ftd_proyectos",
            joinColumns= @JoinColumn(name="ftd_id"),
            inverseJoinColumns = @JoinColumn(name="proyecto_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    private List<Proyectos> proyectos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "tutor_id")
    private Tutores tutores;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "grupo_id")
    private Grupos grupos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "enlace_id")
    private Enlace enlace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="estatus_id")
    private EstatusInfotec estatusInfotec;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="ftd_cursos",
    joinColumns = @JoinColumn(name = "ftd_id"),
    inverseJoinColumns = @JoinColumn(name="curso_id"))
    @JsonIgnoreProperties("datosFTD")
    private List<Cursos> cursos;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "person_id")
    private DatosPersonales datosPersonales;

}
