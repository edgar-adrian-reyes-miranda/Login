package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_grupo;
    private String nombre_grupo;
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<DatosFTD> datosFTDS;
}
