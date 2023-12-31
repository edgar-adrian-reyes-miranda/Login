package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_person;
    private String nombre;
    private String p_apellido;
    private String s_apellido;
    @Size(max=18, message = "EL numero de caracteres de CURP son 18")
    private String curp;
    private String direccion;
    private String estados;
    private String municipio;
    @Min(value = 10, message = "Ingrese su edad")
    private Integer edad;
    @Digits(integer=10, fraction=0, message ="El maximo de numero de digitos son 10" )
    private Long telefono;
    @Digits(integer=10,fraction= 0, message = "El maximo de numero son 10 digitos")
    private Long telefono_casa;
    private String correo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosPersonales")
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosPersonales")
    @JoinColumn(name = "ftd_id")
    private DatosFTD datosFTDS;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosPersonales")
    @JoinColumn(name = "ingreso_id")
    private DatosIngresos datosIngresos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosPersonales")
    @JoinColumn(name ="escolar_id")
    private DatosEscolares datosEscolares;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosPersonales")
    @JoinColumn(name="id")
    private Usuario usuario;
   
}
