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
@Table(name="estatus")
public class EstatusInfotec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estatus;
    private String tipo_estaus;
    @OneToMany(mappedBy = "estatusInfotec",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("estatus")
    private List<DatosFTD> datosFTD;

}
