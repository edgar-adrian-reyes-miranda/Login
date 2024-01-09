package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="escolares")
public class DatosEscolares {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_escolar;
    private String matricula;
    private String correo_inst;
    private String carrera;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosEscolares")
    @JoinColumn(name="periodo_id")
    private Periodo periodo;

    @ManyToOne(fetch =FetchType.EAGER)
    @JsonIgnoreProperties("datosEscolares")
    @JoinColumn(name="uni_id")
    private Universidades universidades;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosEscolares")
    @JoinColumn(name="plan_id")
    private PlanEducativo planEducativo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosEscolares")
    @JoinColumn(name = "modalidad_id")
    private ModalidadesEscolares modalidadesEscolares;

    @OneToMany(mappedBy = "datosEscolares",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosEscolares")
    private List<DatosPersonales> datosPersonales;
}
