package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
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

}
