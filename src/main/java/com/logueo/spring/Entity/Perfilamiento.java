package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="perfilamiento")
public class Perfilamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_perfilamiento;
    private String nombre;

    @OneToMany(mappedBy = "perfilamiento",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosIngresos>datosIngresos;
   /* @Column(name="activo")
    private boolean activo=true;*/
}
