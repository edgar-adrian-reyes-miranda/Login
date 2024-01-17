package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="modalidades")
public class ModalidadesEscolares {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id_modalidad;
    private String tipo_modalidad;
    @OneToMany(mappedBy = "modalidadesEscolares",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<DatosEscolares> datosEscolares;
}
