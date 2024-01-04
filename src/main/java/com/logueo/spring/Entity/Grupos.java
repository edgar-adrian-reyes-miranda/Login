package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

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
    @JsonIgnore
    private List<DatosFTD> datosFTDS;

}
