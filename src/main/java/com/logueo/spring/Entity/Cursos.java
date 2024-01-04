package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String tipo_estatus;
    private String unidad;
    @ManyToMany(mappedBy = "cursos",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosFTD> datosFTD;
}
