package com.logueo.spring.DTO;

import java.io.Serializable;
import java.util.List;

import com.logueo.spring.Entity.DatosPersonales;
import lombok.*;
@Data

public class GeneroDto implements Serializable {

    private static final long serialVersionUID=1L;
    private String genero;
    private List<DatosPersonales> datosPersonales;
}
