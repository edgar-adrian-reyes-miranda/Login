package com.logueo.spring.Entity;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cursos")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_curso;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Unidades unidades;
    @ManyToMany
    private List<DatosFTD> datosFTDS;
}
