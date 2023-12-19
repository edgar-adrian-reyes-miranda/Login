package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="enlaces")
public class Enlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_enlace;
    private String tipo_enlace;
    @OneToMany(mappedBy = "enlace", cascade =  CascadeType.ALL)
    private List<DatosFTD> datosFTDS;
}
