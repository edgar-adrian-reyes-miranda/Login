package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="modalidad")
public class Modalidad {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_modalida;
    private String tipo_modalidad;
    @OneToMany(mappedBy = "modalidad", fetch = FetchType.EAGER)
     @JsonIgnore
    private List<DatosFTD> datosFTDS;

}
