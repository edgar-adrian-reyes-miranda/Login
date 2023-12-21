package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="turor")
public class Tutores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tutor;
    private String nombre;
}
