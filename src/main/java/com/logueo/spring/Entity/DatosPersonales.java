package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="personales")
public class DatosPersonales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_person;
    private String nombre;
    private String p_apellido;
    private String s_apellido;
    private String curp;
    private String direccon;
    private int edad;
    private int telefono;
    private int telefono_casa;
    private String correo;
}
