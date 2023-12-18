package com.logueo.spring.Entity;
import lombok.*;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="unidades")
public class Unidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_unidad;
    private String nombre;
   @ManyToOne
   @JoinColumn(name="curso_id")
    private Cursos cursos;
}
