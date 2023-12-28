package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="perfilamiento")
public class Perfilamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_perfilamiento;
    private String nombre;
   /* @Column(name="activo")
    private boolean activo=true;*/
}
