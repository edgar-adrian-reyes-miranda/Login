package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="estausInfotec")
public class EstausInfotec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estaus;
    private String tipo_estatus;
    @ManyToOne
    @JoinColumn(name="ftd_id")
    private DatosFTD datosFTD;
}
