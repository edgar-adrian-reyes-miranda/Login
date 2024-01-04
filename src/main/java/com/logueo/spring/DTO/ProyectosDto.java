package com.logueo.spring.DTO;

import java.io.Serializable;

import lombok.*;
@Data
public class ProyectosDto implements Serializable {

    private static final long serialVersionUID= 1L;
    private String nombre;
    private String avance;
    private String evaluacion;

}
