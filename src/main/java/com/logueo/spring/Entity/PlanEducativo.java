package com.logueo.spring.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="planes")
@SQLDelete(sql = "UPDATE PLANES SET deleted = true WHERE id_plan = ?")
@Where(clause = "deleted= false")
public class PlanEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plan;
    private String nombre;
    @OneToMany(mappedBy = "planEducativo", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DatosEscolares>datosEscolares;

    @Column(name="deleted")
    private boolean deleted = false;
    public void restore(){
        this.deleted= false;
    }
}
