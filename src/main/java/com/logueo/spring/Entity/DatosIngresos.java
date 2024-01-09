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
@Table(name="ingresos")
public class DatosIngresos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingreso;
    private String cv;
    private String historial_Academico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tramite_id")
    @JsonIgnoreProperties("datosIngresos")
    private Tramite tramite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosIngresos")
    @JoinColumn(name = "perfilamiento_id")
    private Perfilamiento perfilamiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosIngresos")
    @JoinColumn(name = "horario_id")
    private Horarios horarios;

    @OneToMany(mappedBy = "datosIngresos", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("datosIngresos")
    private List<DatosPersonales> datosPersonales;
}
