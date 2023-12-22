package com.logueo.spring.Entity;

import lombok.*;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="modalidades")
public class ModalidadesEscolares {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_modalidad;
    private String tipo_modadlidad;

}