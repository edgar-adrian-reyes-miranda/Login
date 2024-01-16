package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String tipo_genero;
    @OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("genero")
    private List<DatosPersonales> datosPersonales;
}
