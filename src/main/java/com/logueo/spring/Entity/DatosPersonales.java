package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="personales")
public class DatosPersonales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long id_person;
    private String nombre;
    private String p_apellido;
    private String s_apellido;
    @Size(max = 18, message = "EL numero de caracteres de CURP son 18")
    private String curp;
    private String direccion;
    private String estados;
    private String municipio;
    private Integer edad;
    @Digits(integer=10, fraction=0, message ="El maximo de numero de digitos son 10" )
    private Long telefono;
    @Digits(integer=10,fraction= 0, message = "El maximo de numero son 10 digitos")
    private Long telefono_casa;
    private String correo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @OneToMany(mappedBy = "datosPersonales", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosEscolares> datosEscolares;

    @OneToMany(mappedBy = "datosPersonales", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosIngresos> datosIngresos;

    @OneToMany(mappedBy = "datosPersonales", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosFTD> datosFTD;
    

   
}
