package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;


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
    
    @ManyToOne
    @JoinColumn(name="curso_id")
    private Cursos cursos;

    @ManyToOne
    @JoinColumn(name="estatus_id", nullable = false, updatable = false)
    private EstatusInfotec estatusInfotec;
    @ManyToOne
    @JoinColumn(name="person_id")
    private DatosPersonales datosPersonales;

}
