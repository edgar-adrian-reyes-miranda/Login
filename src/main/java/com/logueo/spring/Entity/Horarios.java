package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="horario")
public class Horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_horario;
    private String horario;
    @OneToMany(mappedBy = "horarios", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosIngresos> datosIngresos;
}
