package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;


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
    @ManyToOne
    @JoinColumn(name="tramite_id")
    private Tramite tramite;

}
