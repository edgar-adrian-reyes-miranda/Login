package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="carreras")
public class Carreras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrera;
    private String nombre;


}
