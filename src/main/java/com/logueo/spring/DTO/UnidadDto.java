package com.logueo.spring.DTO;

import java.io.Serializable;

import lombok.*;
@Data
public class UnidadDto implements Serializable {

    private static final Integer serialVersionUID=1;
    private String nombre;
    private Cursos cursos;
}
