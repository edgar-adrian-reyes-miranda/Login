package com.logueo.spring.Entity;

import jakarta.validation.constraints.*;
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
    @Size(max=18, message = "EL numero de caracteres de CURP son 18")
    private String curp;
    private String direccion;
    @Min(value = 0, message = "Ingrese su edad")
    private Integer edad;
    @Size(max=10, message ="El maximo de numero de digitos son 10" )
    private int telefono;
    @Size(max=10, message = "El maximo de numero son 10 digitos")
    private int telefono_casa;
    private String correo;
}
