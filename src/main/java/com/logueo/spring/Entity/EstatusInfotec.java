package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;

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
