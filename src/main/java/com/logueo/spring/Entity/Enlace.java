package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="enlace")
public class Enlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_enlace;
    private String tipo_enlace;

    @OneToMany(mappedBy = "enlace", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosFTD> datosFTD;

}
