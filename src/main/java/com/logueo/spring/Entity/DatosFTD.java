package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import java.util.Date;
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
    private Date fecha_ingreso;
    private Date fecha_termino;
    private String correo_becario;
    private int matricula_ftd;
    private String beca;
    private String becadocumenot;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name="ftd_cursos",
    joinColumns = @JoinColumn(name = "ftd_id"),
    inverseJoinColumns = @JoinColumn(name="curso_id"))
    private List<Cursos> cursos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name="estatus_id")
    private EstatusInfotec estatusInfotec;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "modalida_id")
    private Modalidad modalidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "enlace_id")
    private Enlace enlace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "grupo_id")
    private Grupos grupos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "tutor_id")
    private Tutores tutores;

    @OneToMany(mappedBy = "datosFTDS",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosPersonales> datosPersonales;
}
