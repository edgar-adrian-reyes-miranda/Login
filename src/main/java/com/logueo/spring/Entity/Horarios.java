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
@Table(name="horario")
public class Horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_horario;
    private String horario;
    @OneToMany(mappedBy = "horarios", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
    private List<DatosIngresos> datosIngresos;
}
