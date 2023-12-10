package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="becas")
public class Beca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_beca;
    private String nombre_beca;
    private String Monto;

    @OneToMany(mappedBy = "beca", cascade =  CascadeType.ALL)
    private List<DocumentoBeca> documentoBecas;
    @OneToMany(mappedBy = "beca", cascade = CascadeType.ALL)
    private List<DatosFTD> datosFTDs;
}    
