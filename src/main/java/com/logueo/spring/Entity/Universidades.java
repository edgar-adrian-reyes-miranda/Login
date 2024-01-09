package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
        @JsonIgnoreProperties("universidades")
        private List<DatosEscolares>datosEscolares;

}