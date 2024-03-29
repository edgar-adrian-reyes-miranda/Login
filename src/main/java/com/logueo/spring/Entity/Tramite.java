package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tramite")

public class Tramite {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_tramite;
    private String tipo_tramite;
    @OneToMany(mappedBy = "tramite",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosIngresos> datosIngresos;

}
