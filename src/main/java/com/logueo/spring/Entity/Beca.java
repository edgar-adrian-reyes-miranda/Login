package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="beca")
public class Beca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_beca;
    private String nombre;
    private String documento;
    private String pago;
    private String cuenta;
}
