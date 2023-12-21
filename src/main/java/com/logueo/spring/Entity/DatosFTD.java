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
    private Date fehca_ingreso;
    private Date fecha_termino;
    private String correo_becario;
    private int matriculaftd;
}
