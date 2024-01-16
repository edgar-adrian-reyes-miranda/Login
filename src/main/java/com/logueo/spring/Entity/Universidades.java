package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        @JsonIgnoreProperties({"hibernateLazyInitializaer", "handler"})
        private List<DatosEscolares>datosEscolares;

}