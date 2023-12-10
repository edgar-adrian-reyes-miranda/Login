package com.logueo.spring.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tramites")
public class Tramite {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tramite;
    private String tipo_tramite; 
    @OneToMany(mappedBy = "tramite", cascade = CascadeType.ALL)
    private List<DatosIngresos> datosIngresos;
    @ManyToMany
    @JoinTable(name="tramite_documento",
    joinColumns = @JoinColumn(name="asistencia_mensual"),
    inverseJoinColumns = @JoinColumn(name="tramite"))
    private List<TramiteDocumento> documento_asitencia;
}
