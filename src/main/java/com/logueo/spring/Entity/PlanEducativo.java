package com.logueo.spring.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="planes")
public class PlanEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plan;
    private String nombre;
    @OneToMany(mappedBy = "planEducativo", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosEscolares>datosEscolares;
}
