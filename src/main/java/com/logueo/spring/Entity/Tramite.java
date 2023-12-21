package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tramite")
public class Tramite {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_tramite;
    private String tipo_tramite;
}
