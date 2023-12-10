package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tramitedocumento")
public class TramiteDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tramite_documento;
    @ManyToMany
    private List<Tramite> tramiteLis;
    @Lob
    private byte[] asitencia_menual;
    @Lob
    private byte[] act_menusla;

}
