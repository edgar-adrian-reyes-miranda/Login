package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="ftd")
public class DatosFTD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ftd;
    private String area;
    private String fecha_ingreso;
    private String fecha_termino;
    private String correo_becario;
    private String matricula_ftd;
    private String beca;
    private String becadocumenot;
    
    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonIgnoreProperties
    @JoinTable(name="ftd_cursos",
    joinColumns = @JoinColumn(name = "ftd_id"),
    inverseJoinColumns = @JoinColumn(name="curso_id"))
    private List<Cursos> cursos;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnoreProperties
    @JoinColumn(name="estatus_id")
    private EstatusInfotec estatusInfotec;


    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnoreProperties
    @JoinColumn(name = "enlace_id")
    private Enlace enlace;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnoreProperties
    @JoinColumn(name = "grupo_id")
    private Grupos grupos;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonIgnoreProperties
    @JoinColumn(name = "tutor_id")
    private Tutores tutores;

    @ManyToMany(fetch = FetchType.EAGER)
    //@JsonIgnoreProperties
    @JoinTable(name="ftd_proyectos",
    joinColumns= @JoinColumn(name="ftd_id"),
    inverseJoinColumns = @JoinColumn(name="proyecto_id"))
    private List<Proyectos> proyectos;
    
    @ManyToOne(fetch = FetchType.EAGER)
    //@JsonIgnore
    @JoinColumn(name = "person_id")
    private DatosPersonales datosPersonales;

}
