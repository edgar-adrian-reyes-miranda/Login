package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="proyectos")
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto;
    private String nombre;
    private String avance;
    private int evaluacion;
    @ManyToMany(mappedBy = "proyectos")
    private List<DatosFTD> datosFTDS;
}
