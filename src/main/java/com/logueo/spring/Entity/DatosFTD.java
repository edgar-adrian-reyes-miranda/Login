package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="datos_ftd")
public class DatosFTD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ftd;
    private String area;
    private String tutor;
    private Date fecha_inicio;
    private Date fecha_final;
    private String correo_becario;
    private int matricula;
    @ManyToMany
    @JoinTable(name = "proyectos_datosftd",
               joinColumns = @JoinColumn(name="ftd_id"),
                inverseJoinColumns = @JoinColumn(name="proyecto_id"))
    private List<Proyectos> proyectos;
    @ManyToMany
    @JoinTable(name="cursos_datosftd",
                joinColumns = @JoinColumn(name="ftd_id"),
                inverseJoinColumns = @JoinColumn(name="curso_id"))
    private List<Cursos>  cursos;
    @ManyToOne
    @JoinColumn(name="grupos")
    private Grupo grupo;
    @ManyToOne
    @JoinColumn(name="enlaces")
    private Enlace enlace;
    @OneToMany(cascade = CascadeType.ALL)
    private List<EstausInfotec> estausInfotecs;
    @ManyToOne
    @JoinColumn(name="beca_id")
    private Beca beca;
    @ManyToMany
    private List<Datospersonales> datospersonales;
}
