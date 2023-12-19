package com.logueo.spring.Entity;
import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="documentacion_beca")
public class DocumentoBeca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documento;
    @Lob
    private byte[] pago;
    @Lob
    private  byte[] cuenta;
    @ManyToOne
    @JoinColumn(name = "beca_id")
    private Beca beca;
}
