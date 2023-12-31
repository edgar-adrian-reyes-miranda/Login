package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_turno;
    private String tipo_turno;
    @OneToMany(mappedBy = "turno", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("turno")
    private List<DatosFTD> datosFTDS;
}
