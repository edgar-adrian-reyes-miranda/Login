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
@Table(name="periodo")
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_periodo;
    private String tipo_periodo;
    @OneToMany(mappedBy = "periodo", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("periodo")
    private List<DatosEscolares> escolares;
}
