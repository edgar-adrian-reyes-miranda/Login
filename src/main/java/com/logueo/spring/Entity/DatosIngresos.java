package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;


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
    private Modalidad modalidad;
    @Lob
    private byte[] historialAcademico;
    @Lob
    private byte[] cv;
    @ManyToOne
    @JoinColumn(name="tramite_tipo")
    private Tramite tramite;
    
    @ManyToMany
    @JoinTable(name="datosingreo_perfilamiento",
                joinColumns = @JoinColumn(name = "perfilamiento_id"),
                inverseJoinColumns = @JoinColumn(name = "ingreso_id"))
    private List<Perfilamiento> perfilamientos;
    @ManyToMany
    private List<Datospersonales> datospersonales;
}
