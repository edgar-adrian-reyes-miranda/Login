package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="datos_ingreso")
public class DatosIngresos {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id_ingreso;
    @Enumerated(EnumType.STRING)
    private Horarios horario;
    @Enumerated(EnumType.STRING)
    private Modalidad modalidad;

}
