package com.logueo.spring.Entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="universidades")
public class Universidades{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_uni;
        private String nombre;

        @JsonIgnore
        private Boolean activo=true;

        @OneToMany(mappedBy = "universidades",fetch = FetchType.EAGER)
        @JsonIgnore
        private List<DatosEscolares>datosEscolares;

}
