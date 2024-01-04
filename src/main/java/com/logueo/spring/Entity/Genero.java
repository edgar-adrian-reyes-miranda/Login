package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genero;
    private String genero;
    @OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosPersonales> datosPersonales;
}
