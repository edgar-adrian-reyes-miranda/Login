package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="proyecto")
@Where(clause = "status= true")
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto;
    private String nombre;
    private String avance;
    private String evaluacion;

    @ManyToMany(mappedBy = "proyectos", fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JsonIgnoreProperties("proyectos")
    private List<DatosFTD> datosFTD;

    @Column(name="status", columnDefinition = "boolean DEFAULT  'true'")
    private Boolean status=true;

}