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
@Table(name="escolares")
public class DatosEscolares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_escolar;
    private String correo_inst;
    private String carrera;
    private String matricula;

    @ManyToOne(fetch =FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="uni_id")
    private Universidades universidades;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name = "modalidad_id")
    private ModalidadesEscolares modalidadesEscolares;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="plan_id")
    private PlanEducativo planEducativo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name="periodo_id")
    private Periodo periodo;
    
    @ManyToOne( fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    @JoinColumn(name ="person_id")
    private DatosPersonales datosPersonales;

    
}
