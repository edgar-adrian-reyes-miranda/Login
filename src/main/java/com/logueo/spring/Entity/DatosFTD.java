package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


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


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="proyecto_id")
    private Proyectos proyectos;

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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="curso_id")
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    private Cursos cursos;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "person_id")
    private DatosPersonales datosPersonales;

}
