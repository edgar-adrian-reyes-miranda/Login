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
@Table(name="modalidad")
public class Modalidad {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_modalida;
    private String tipo_modalidad;
    @OneToMany(mappedBy = "modalidad", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosIngresos> datosIngresos;

}
