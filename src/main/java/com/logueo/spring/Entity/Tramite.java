package com.logueo.spring.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tramites")
public class Tramite {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tramite;

}
