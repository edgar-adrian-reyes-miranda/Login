package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
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
    @JsonIgnore
    private List<DatosEscolares> escolares;
}
