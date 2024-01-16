package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="tutor")
public class Tutores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tutor;
    private String nombre;

    @OneToMany(mappedBy = "tutores", fetch = FetchType.LAZY)
    //@JsonIgnoreProperties
    private List<DatosFTD> datosFTDS;
}
