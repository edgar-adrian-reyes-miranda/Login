package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tutor")
public class Tutores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tutor;
    private String nombre;

    @OneToMany(mappedBy = "tutores", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosFTD> datosFTD;
}
