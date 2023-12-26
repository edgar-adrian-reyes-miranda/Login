package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="universidades")
public class Universidades{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_uni;
        private String nombre;

}
