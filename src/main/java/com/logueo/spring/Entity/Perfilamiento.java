package com.logueo.spring.Entity;
import lombok.*;

import java.util.List;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="perfilamiento")
public class Perfilamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_perfilamiento;
    private String tipo_perfilamiento;

    @ManyToMany
    private List<DatosIngresos> datosIngresos;


}
