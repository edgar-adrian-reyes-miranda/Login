package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

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
        @OneToMany(mappedBy = "universidades",fetch = FetchType.EAGER)
        @JsonIgnore
        private List<DatosEscolares>datosEscolares;

}