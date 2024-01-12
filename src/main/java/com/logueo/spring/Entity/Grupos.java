package com.logueo.spring.Entity;

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
@Table(name="grupo")
public class Grupos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_grupo;
    private String nombre;
    @OneToMany(mappedBy = "grupos",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("grupo")
    private List<DatosFTD> datosFTDS;

}
