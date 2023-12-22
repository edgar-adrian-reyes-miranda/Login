package com.logueo.spring.DTO;


import lombok.*;
import java.io.Serializable;


@Data
public class CursosDto implements  Serializable{

    private static  final long serialVersionUID= 1L;
    private String nombre;
    private String tipo_estatus;
    private String unidad;
}
