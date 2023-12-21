package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="grupo")
public class Grupos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_grupo;
    private String nombre;
}
