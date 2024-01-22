package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ingresos")
public class DatosIngresos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingreso;
    private String cv;
    private String historial_Academico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tramite_id")
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="perfilamiento_id")
    private Perfilamiento perfilamiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="turno_id")
    private Turno turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "horario_id")
    private Horarios horarios;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="modalida_id")
    private Modalidad modalidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "person_id")
    private DatosPersonales datosPersonales;


    //@JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
}
