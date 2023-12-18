package com.logueo.spring.Entity;

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
    private Long id_curso;
    private String nombre;
    @OneToMany(mappedBy="cursos", cascade = CascadeType.ALL)
    private List<Unidad> unidades;

    @ManyToMany
    private List<DatosFTD> datosFTDS;
}
